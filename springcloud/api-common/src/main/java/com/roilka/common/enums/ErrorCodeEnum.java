package com.roilka.common.enums;


/**
 * 
* 类名: ErrorCodeEnum.java
* 包名 : com.roilka.common.enums
* 详细描述: 自定义异常枚举类
* 开发人员： zhanghui1
* 开发日期：2018年10月11日 下午9:14:02
*
 */
public enum ErrorCodeEnum {

	/**
	 * 10000-19999 共通定义	
	 */
    SUCCESS(10000, "success", "操作成功"),
    URL_REQUEST_ERROR(10001, "url.request.error", "异常接口调用"),
    PROCESS_FAIL(10002, "PROCESS_FAIL", "服务器处理失败"),
    TOO_MANY_REQUEST(10003, "TOO_MANY_REQUEST", "访问过于频繁"),
    PERMISSION_DENY(10004, "PERMISSION_DENY", "用户服务无权限"),
    AUTHENTICATION_EXPIRED(10005, "AUTHENTICATION_EXPIRED", "身份认证过期"),
    SUCCESS_EXIST(10006, "SUCCESS_EXIST", "记录已存在"),
    SUCCESS_ACOUNT_NOT_EXIST(10007, "SUCCESS_ACOUNT_NOT_EXIST", "账号不存在"),
    IP_LIMIT(10008, "IP_LIMIT", "IP限制"),
    PARAM_ERROR(10009, "PARAM_ERROR", "参数错误"),
    PARAM_IS_NULL(10010, "PARAM_IS_NULL", "参数为空"),
    INSUFFICIENT_USER_PERMISSIONS(10011, "INSUFFICIENT_USER_PERMISSIONS", "用户权限不足"),
    INVALID_METHOD(10012, "INVALID_METHOD", "方法名不存在"),
    REQUEST_API_NOT_FOUND(10013, "REQUEST_API_NOT_FOUND", "请求的方法名不存在"),
    INVALID_FORMAT(10014, "INVALID_FORMAT", "无效的数据格式"),
    MISSING_APP_KEY(10015, "MISSING_APP_KEY", "缺少AppKey参数"),
    INVALID_APP_KEY(10016, "INVALID_APP_KEY ", "非法的APP Key"),
    INVALID_ACCESS_TOKEN(10017, "INVALID_ACCESS_TOKEN", "无效的access token"),
    USER_DOES_NOT_EXISTS(10018, "USER_DOES_NOT_EXISTS", "用户不存在"),
    CONTENT_IS_NULL(10019, "CONTENT_IS_NULL", "内容为空"),
    CONTENT_IS_ILLEGAL(10020, "CONTENT_IS_ILLEGAL ", "包含非法内容"),
    PHONE_NUMBER_HAS_BEEN_USED(10020, "PHONE_NUMBER_HAS_BEEN_USED", "该手机号已经被使用"),
    AUTH_FAILD(10021, "AUTH_FAILD", "验证失败"),
    ILLEGAL_OPERATION(10022, "ILLEGAL_OPERATION", "非法操作"),
    USERNAME_OR_PASSWORD_ERROR(10023, "USERNAME_OR_PASSWORD_ERROR", "用户名或者密码错误"),
    OPERATION_FAILED(10024, "OPERATION_FAILED", "操作失败"),
    SYSTEM_ERROR(10025, "SYSTEM_ERROR", "系统异常"),
    CALLSERVICCE_ERROR(10026, "CALLSERVICCE_ERROR", "调用服务异常"),
    VERSION_ERROR(10027, "VERSION_ERROR", "版本号错误"),
    SUCCESS_NOT_EXIST(10028, "SUCCESS_NOT_EXIST", "数据不存在"),
    REPEAT_OPERATION(10029, "REPEAT_OPERATION", "重复操作"),
    SHOP_IS_NOT_EXIST(10030, "SHOP_IS_NOT_EXIST", "门店不存在"),
    
    //登陆限制 10200 ~ 10299 段 留给登陆相关 By 林云琦
    LOGOUT_BY_LIMIT_STRATEGY(10200, "LOGOUT_BY_LIMIT_STRATEGY", "您账号已被强制登出"),
    LOGIN_FAILED_FIVE_TIMES(10201, "LOGIN_FAILED_FIVE_TIMES", "密码错误5次，您的账号已经被封停30分钟"),
    LOGIN_FAILED_WITH_TIMES (10202, "LOGIN_FAILED_WITH_TIMES", "密码错误{0}次"),
    SMSCODE_REQUEST_MORE_THEN_FIVE_TIMES(10203, "SMSCODE_REQUEST_MORE_THEN_FIVE_TIMES", "短信验证码请求次数过多，请30分钟之后再获取"),
    CHANGE_DEVICE_MORE_THEN_FIVE_TIMES(10204, "CHANGE_DEVICE_MORE_THEN_FIVE_TIMES", "切换设备过于频繁，您的账号已经被封停30分钟"),
    DIFF_LAST_LOGIN_DEVICE(10205, "DIFF_LAST_LOGIN_DEVICE", "您的账号尝试在非常用设备登陆，请用使用短信验证码方式重新登陆"),
    
    NO_NEED_EXECUTE(11000, "NO_NEED_EXECUTE", "不需要执行"),
    

	/**
	 * 20000-29999 Workshop相关业务定义 By 潘晓飞
	 */
    RO_IS_NOT_EXIST(20001, "RO_IS_NOT_EXIST", "工单不存在"),
    RO_LOG_IS_NOT_EXIST(20002, "RO_LOG_IS_NOT_EXIST", "工单维修日志不存在"),
    RO_DISABLE_ERROR(20003, "RO_DISABLE_ERROR", "工单作废失败"),
    RO_CREATE_ERROR(20004, "RO_CREATE_ERROR", "工单创建失败"),
    RO_IS_INVALID(20035, "RO_IS_INVALID", "工单无效的"),
    RO_IS_EXECUTE(20036, "RO_IS_EXECUTE", "工单已经在处理中"),
    RO_RECEIVEID_NOT_MATCH(20037, "RO_RECEIVEID_NOT_MATCH", "工单的receiveid不匹配"),
    RO_IS_FINISHED(20038, "RO_IS_FINISHED", "工单已经完成！"),
    RO_EVIDENCE_IS_MISSING(20039, "RO_EVIDENCE_IS_MISSING", "损伤照片未拍完整！"),

    PROCESS_IS_NOT_PRIVILEGE(20100, "PROCESS_IS_NOT_PRIVILEGE", "工单的工序没有权限执行"),
    PROCESS_IS_EXECUTE_ERROR(20101, "PROCESS_IS_EXECUTE_ERROR", "工序执行错误"),
    PROCESS_REVOKE_ERROR(20102, "PROCESS_REVOKE_ERROR", "工序撤销失败"),
    PROCESS_DISTRIBUTE_ERROR(20103, "PROCESS_DISTRIBUTE_ERROR", "工序派工失败"),
    PROCESS_PAUSE_ERROR(20104, "PROCESS_PAUSE_ERROR", "工序中断失败"),
    PROCESS_TECH_NOT_FIND(20105, "PROCESS_TECH_NOT_FIND", "工序没有技师"),
    PROCESS_TECH_IS_EXECUTE(20106, "PROCESS_TECH_IS_EXECUTE", "工序技师已经处理中"),
    PROCESS_FINISHED(20107, "PROCESS_FINISHED", "工序已经完工！"),
    PROCESS_IS_EXECUTE(20108, "PROCESS_IS_EXECUTE", "工序已经在处理中！"),
    PROCESS_EVIDENCE_IS_MISSING(20109, "PROCESS_EVIDENCE_IS_MISSING", "本工序要求完工前拍照，施工后照片未拍全不能完工！"),
    PROCESS_IS_NOT_EXIST(20110, "PROCESS_IS_NOT_EXIST", "工序不存在！"),
    PROCESS_IS_NOT_NEED_PHOTO(20111, "PROCESS_IS_NOT_NEED_PHOTO", "本工序不需要拍照！"),
    PROCESS_IS_STARTED(20112, "PROCESS_IS_STARTED", "当前工序已经开工！"),

    USER_IS_NOT_AUTHORITY(20201, "USER_IS_NOT_AUTHORITY", "用户没有权限！"),
    
    
    
	/**
	 * 30000-39999 TC相关业务定义 By 王淮增	
	 */
    MESSAGE_CODE_SUCCESS(30001,"MESSAGE_CODE_SUCCESS","短信发送成功!"),
    MOBILE_NUMBER_INVALID(30002,"MOBILE_NUMBER_INVALID","手机号码无效!"),
    MESSAGE_CODE_SEND_FAIL(30003,"MESSAGE_CODE_SEND_FAIL","短信验证码发送失败!"),
    CODE_VALID_INVALID(30004,"CODE_VALID_INVALID","短信验证码失效!"),
    CODE_VALID_FAIL(30005,"CODE_VALID_FAIL","短信验证码匹配失败!"),
    
    //Xue 30200 ~ 30399
    EXAM_NOT_EXIST(30201,"EXAM_NOT_EXIST","考试不存在,非法请求!"),
    EXAM_NOT_POST(30202,"EXAM_NOT_POST","考试没有发布,禁止访问!"),
    ILLEGAL_QUIZ_DATA_SUBMIT(30203,"ILLEGAL_QUIZ_DATA_SUBMIT","非法的测验考试数据提交!"),
    EXERCISE_NOT_FOUND(30204,"EXERCISE_NOT_FOUND","该考试不存在或没有发布(已隐藏)!"),
    ERROR_SUBMITTED_PAPER(30205,"ERROR_SUBMITTED_PAPER","对不起,您已提交过本答卷,请勿重复提交了!"),
    ERROR_SUBMITTED_PAPER_ONCE(30206,"ERROR_SUBMITTED_PAPER_ONCE","对不起,您已提交过本答卷并且没有批改处理完成,请耐心等待，不要重复提交!"),
    USER_NOT_REL_EXAM(30207, "USER_NOT_REL_EXAM", "用户不在试卷用户表,不是本考试的用户,不可参考"),
    USER_NOT_EXAM_TIME(30208, "USER_NOT_EXAM_TIME", "不在考试时间范围之内,不可参考"),
    EXAM_GT_MAXATTEMPT(30209, "EXAM_GT_MAXATTEMPT", "超过考试最大允许次数,不可参考"),
    EXAM_PASS_SCORE(30210, "EXAM_PASS_SCORE", "已通过的考试,不可参考"),
    EXAM_FB_STATUS_ONE(30211, "EXAM_FB_STATUS_ONE", "需要人工批改,不可参考"),
    EXAM_FB_STATUS_PASS(30212, "EXAM_FB_STATUS_PASS", "已批改完成考试通过,不可参考"),
    COURSE_LEARNINGTIME_STATUS_NONE(30213, "COURSE_LEARNINGTIME_STATUS_NONE", "课时不达标,不可参考"),    
    
	/**
	 * 40000-49999 ShopBoss相关业务定义 By 易天乐
	 */
       

    
    
    
    /**
	 * 结束专用定义
	 */
    End(99999, "End", "不需要执行");
    
    private int    code;
    private String name;
    private String desc;

    ErrorCodeEnum(int code, String name, String desc) {

        this.code = code;
        this.name = name;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
