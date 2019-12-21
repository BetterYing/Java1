import java.io.File;

public class IODemo {
    public static void main(String[] args) {
        File file = new File("E:" + File.separator + "四级词汇");
        System.out.println("可执行/可读/可写");
        System.out.println(file.canExecute());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());

        System.out.println("是否存在/是文件夹/是文件/绝对路径/隐藏");
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.isAbsolute());
        System.out.println(file.isHidden());

        System.out.println("空间");
        System.out.println(file.getUsableSpace());
        System.out.println(file.getFreeSpace());
        System.out.println(file.getTotalSpace());

        System.out.println("文件大小/名字/上次修改时间");
        System.out.println(file.length());
        System.out.println(file.getName());
        System.out.println(file.lastModified());


        System.out.println(file.getParent());

    }


}
