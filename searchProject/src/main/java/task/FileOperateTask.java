package task;

import app.FileMeta;
import dao.FileOperateDAO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileOperateTask implements FileScanCallBack {
    @Override
    public void execute(File dir) {

        if (dir.isDirectory()) {
            //本地文件
            File[] children = dir.listFiles();
            List<FileMeta> localMetas = compose(children);

            //数据库文件，jdbc查询实现（根据路径查询路径下的所有文件/文件夹）
            List<FileMeta> metas = FileOperateDAO.query(dir.getPath());


            //数据库有，本地文件没有的文件
            for (FileMeta meta : metas ) {
                if (!localMetas.contains(meta)) {
                    //如果meta是文件夹，还要删除文件/文件夹
                    FileOperateDAO.delect(meta);
                }
            }

            //本地有，数据库没有的文件
            for (FileMeta localMeta : localMetas) {
                if (!metas.contains(localMeta)) {
                    FileOperateDAO.insert(localMeta);
                }
            }

        }
    }

    private List<FileMeta> compose(File[] children) {
        List<FileMeta> metas = new ArrayList<>();
        if (children != null) {
            for (File child : children) {
                //metas.add(new FileMeta(child.getName(),child.getPath(),child.length(),child.lastModified(),child.isDirectory()));
                metas.add(new FileMeta(child));
            }
        }
        return metas;
    }
}
