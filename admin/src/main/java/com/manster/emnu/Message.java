package com.manster.emnu;

/**
 * 返回操作结果消息
 * @Author manster
 * @Date 2021/4/30
 **/
public enum Message {
    SUCCESS_ADD("新增成功"),
    FAILED_ADD ("新增失败"),
    SUCCESS_EDIT ("修改成功"),
    FAILED_EDIT ("修改失败"),
    SUCCESS_DEL("删除成功"),
    FAILED_DEL("删除失败");

    private final String msg;

    private Message(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg ;
    }
}
