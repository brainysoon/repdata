package cn.brainysoon.repdata.service;

/**
 * Created by brainy on 17-7-7.
 */
public interface Constant {

    int MARK_OK = 1;

    int MARK_NOT_OK = -1;

    int SLEAD_ALIVE = 1;

    int SLEAD_DEATH = -1;

    int OPEN_OK = 1;

    int OPEN_DENIED = -1;

    /**
     * 文件存放位置
     */
    String UPLOAD_FILE_SAVE_PATH = "/var/repdata/";

    String REP_DATA_ABSTRACT_URL_PRE_PATH = "http://localhost/repdata/";
}
