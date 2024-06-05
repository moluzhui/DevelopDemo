package org.example.common.utils;

/**
 * .
 *
 * @since 2024/6/4 23:38
 */
public interface CommonConstant {
    /**
     * 请求成功
     */
    int STATUS_SUCCESS = 200;

    /**
     * 请求失败
     */
    int STATUS_ERROR = 201;

    /**
     * 默认用户名
     */
    String USER_NAME = "qishuihe";

    /**
     * 默认密码
     */
    String PASS_WORD = "$2a$10$/Sntcri.oeF7BE2//n2svOStLtRxLp6TqY900HFv60fBxGwNy.uiO";

    /**
     * 请求头的token
     */
    String TOKEN_STR = "token";

    /**
     * 请求头的token
     */
    String FILE_NAME = "_FILE_NAME_";


    String QISHUIHE_LOG="qishihuiLog";

    String QISHUIHE_LOG_GROUP="qishihuiLogGroup";

    /**
     * 前端页面
     */
    String FRONT_PAGE_SIT="FRONT_PAGE_SIT";

    /**
     * 用户名
     */
    String REST_USER_NAME="REST_USER_NAME";

    /**
     * 有效时间
     */
    String VALID_TIME="VALID_TIME";
    /**
     * 验证码
     */
    String VERIFY_CODE = "VERIFY_CODE";
}
