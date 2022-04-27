package cn.enjoy.thread.forkjoin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * 遍历指定目录（含子目录）找寻指定类型文件
 * fork-join的异步操作
 */
public class FindDirsFiles extends RecursiveAction {

    private File path;//当前任务需要搜寻的目录

    public FindDirsFiles(File path) {
        this.path = path;
    }

    @Override
    protected void compute() {

        List<FindDirsFiles> subTasks = new ArrayList<>();

        File[] files = path.listFiles();
        if (files != null ) {
            for (File file : files) {
                if (file.isDirectory()) {
                    subTasks.add(new FindDirsFiles(file));
                }else{
                    if (file.getAbsolutePath().endsWith("txt")) {
                        System.out.println("文件："+file.getAbsolutePath());
                    }
                }
            }
            if (!subTasks.isEmpty()) {
                for (FindDirsFiles subTask : invokeAll(subTasks)) {
                    subTask.join();
                }
            }
        }


    }

    public static void main(String[] args) {
        try {
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            FindDirsFiles task = new FindDirsFiles(new File("F:/"));
            System.out.println("Task is Running......");

            //做点其他工作，跟本次测试关系不大，理解为是在做点其他工作，区分异步就可以
            Thread.sleep(1);
            int otherWork = 0;
            for (int i = 0; i < 100; i++) {
                otherWork = otherWork + 1;
            }
            System.out.println("Main Thread done sth......,otherWork=" + otherWork);
            task.join();//阻塞的方法，异步阻塞
            System.out.println("Task end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
