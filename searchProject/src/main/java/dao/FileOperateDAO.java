package dao;

import app.FileMeta;
import task.FileScanCallBack;
import util.DBUtil;
import util.Pinyin4jUtil;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class FileOperateDAO implements FileScanCallBack {
    @Override
    public void execute(File dir) {

        if (dir.isDirectory()) {
            //本地文件
            File[] children = dir.listFiles();
            List<FileMeta> localMetas = compose(children);

            //数据库文件，jdbc查询实现（根据路径查询路径下的所有文件/文件夹）
            List<FileMeta> metas = query(dir.getPath());

            //本地有，数据库没有的文件
            for (FileMeta localMeta : localMetas) {
                if (!metas.contains(localMeta)) {
                    insert(localMeta);
                }
            }
            //数据库有，本地文件没有的文件
            for (FileMeta meta : metas ) {
                if (!localMetas.contains(meta)) {
                    //如果meta是文件夹，还要删除文件/文件夹
                    delect(meta);
                }
            }
        }

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            try {
                //1.获取数据库连接
                connection = DBUtil.getConnection();
                String sql = "insert into file_meta (name,path,size,last_modified,pinyin," +
                        "pinyin_first,is_directory) values (?,?,?,?,?,?,?)";
                //2.获取操作命令对象
                statement = connection.prepareStatement(sql);
                //填充占位符
                statement.setString(1,dir.getName());
                statement.setString(2,dir.getPath());
                statement.setLong(3,dir.length());
                statement.setTimestamp(4,new Timestamp(dir.lastModified()));

                String pinyin = null;
                String pinyin_first = null;
                //包含中文字符时需要保存全拼和拼音首字母
                if (Pinyin4jUtil.containsChinese(dir.getName())) {
                    String[] pinyins = Pinyin4jUtil.get(dir.getName());
                    pinyin = pinyins[0];
                    pinyin_first = pinyins[1];
                }
                statement.setString(5,pinyin);
                statement.setString(6,pinyin_first);
                statement.setBoolean(7,dir.isDirectory());

                //3.执行sql语句
                statement.executeUpdate();
            } finally {
                DBUtil.close(connection,statement);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
