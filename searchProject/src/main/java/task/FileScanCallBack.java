package task;

import java.io.File;

/**
 * 文件扫描任务的回调方法
 */
public interface FileScanCallBack {


    void execute(File dir);
}
