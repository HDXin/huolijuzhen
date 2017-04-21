package com.sudaotech.core.web.result;

public enum ResultCode {
    // Use standard HTTP status code
    OK("200", "OK"),
    CREATED("201", "Created"),

    BAD_REQUEST("400", "Bad Request"),
    UNAUTHORIZED("401", "Unauthorized"),
    FORBIDDEN("403", "Forbidden"),
    NOT_FOUND("404", "Not Found"),
    CONFLICT("409", "Conflict"),

    INTERNAL_SERVER_ERROR("500", " Internal Server Error"),

    TAG_CATEGORY_NAME_CONFLICT("1201", "标签分类名称不能重复"),

    UPDATE_ERROR("1000", "请求无法处理，原因可能是：1）资源不存在，2）状态已改变。建议重新加载后重试。"),

    //------------------business code
    //user
    ITEM_ID_IS_NULL("1310","ID 不能为空！"),
    ITEM_ID_IS_INVALID("1320","ID 无效"),
    USER_ACCOUNT_CREATE_ERROR("1100", "创建用户账号失败"),
    USER_ACCOUNT_UPDATE_FAIL("1101", "更新用户账号失败"),
    USER_ACCOUNT_GET_FAIL("1102", "获取用户账号失败"),
    USER_ACCOUNT_DELETE_FAIL("1103", "删除用户账号失败"),
    USER_ACCOUNT_DUPLICATED("1104", "用户名重复"),
    USER_CELLPHONE_DUPLICATED("1105", "手机号重复"),
    USER_CELLPHONE_BINDED("1106", "手机号已绑定"),
    USER_CELLPHONE_NOT_EXIST("1108", "手机号不存在"),
    USER_USERNAME_DUPLICATED("1107", "账号重复"),
    USER_CELLPHONE_NOT_BINDED("1109", "手机号未绑定账户"),
    USER_PASSWORD_ERROR("1140", "密码错误"),
    USER_PASSWORD_UPDATE_ERROR("1150", "更新密码失败"),
    PHONE_CODE_ERROR("1200", "手机验证码错误"),
    PHONE_SMS_REJECTED("1201", "发送手机短信失败"),
    SESSION_IS_NULL("4001", "当前用户未登录。"),
    AUTH_FAILED("4000", "登陆授权失败，手机号或密码错误。"),


    //----------------------ServiceType code
    SERVICE_TYPE_RECOMMENT_INVALID("6000", "服务类型推荐数已达系统上线！"),
    BAD_ITEM_ID("6010","无效的 ID !"),
    NOT_PLATFORM_PROVIDER_SERVICE("6020","非平台服务商提供的服务项目没有 选用、取消选用 的操作！"),

    //-------------------审批状态不合法
    APPROVAL_CODE_INVALID("6001", "审批状态码不合法!"),
    NOT_ITEM_EDIT_PRIVILEGE("6002", "没有编辑该内容的权限!"),
    PARK_ID_NOT_NULL("6003","园区ID不能为空!"),
    BATCH_ADD_FAILD("2001", "批量添加失败"),
    PARAM_ERROR("2002", "参数错误"),

    //园区定义相关
    PARK_NAME_EXIST("1001", "园区名称已经存在"),
    RES_CAN_NOT_DISBALE("1001", "已有物业资源引用,无法进行禁用操作"),
    RES_CHOOSE_BAD("1002","合同所选资源已被占用"),
    
    //企业管理
    CURRENT_STATE_IS_NOT_TERMINATED("5001","当前状态不可终止"),
    PHONECODE_IS_ERROR("5002","验证码错误"),
    CORR_STATUS_UPDATE_ERROR("5003", "关联状态已改变。建议重新加载后重试。"),
    CORR_TYPE_UPDATE_ERROR("5003", "关联状态已改变。建议重新加载后重试。"),
    
    //企业风采关联
    ENTERPRISE_DISPLAY_NOT_FOUND_ENTERPRISEINFO("8001","根据企业id未找到企业信息"),
    ENTERPRISE_DISPLAY_ENTERPRISEID_IS_NULL("8002","从SESSION中获取ID为空"),
    ENTERPRISE_DISPLAY_APPROVALSTATUS_IS_NULL("8003","上传的审批状态为空"),
    ENTERPRISE_DISPLAY_BAD_SERVICE("8004","审批接口暂未开通所提交的业务"),
    ENTERPRISE_DISPLAY_ID_IS_NULL("8005","ID为空"),
    ENTERPRISE_DISPLAY_ADMIN_USER_IS_NOT_FOUND("8006","未找到创建者信息"),

    //企业账单
    NOT_FOUND_CONTRACT("7001","未找到合同信息"),
    START_DATE_IS_REQUIRED("7002","合同起始时间不可为空"),
    END_DATE_IS_REQUIRED("7003","合同截止时间不可为空"),
    MONTH_NON_COMPLIANT("7004","账单月份不合规"),
    BILLSTATUS_UPDATE_ERROR("7005", "账单状态已改变。建议重新加载后重试。"),
    PAY_VOUCHER_IS_REQUIRED("7006", "支付凭证信息不可为空"),
    AMOUNT_CAL_ERR("7007", "金额计算错误"),
    NOT_FOUND_BILL("7101","未找到账单信息"),
    COLLECTION_AMOUNT_TOO_LARGE("7008","收款金额不能大于待核销金额"),
    BILL_IS_WRITTEN("7009", "账单已成功核销"),
    ADJUST_AMOUNT_IS_NULL("7010", "调整金额不为空账单已成功核销"),
    URGE_NOT_ENABLED("7011", "催缴功能不可用,请到系统配置中配置"),
    BILL_ALREADY_EXISTS("7012", "该月账单已存在"),
    NOT_FOUND_COST_PRO("7013","未找到合同的费用项目"),
    NOT_FOUND_DOSAGE_COST_PRO("70015","未找到合同的按用量计算的费用项目！"),
    COLLECTION_AMOUNT_IS_INSUFFICIENT("7020","待分摊金额不足"),
    COST_DETAIL_IS_WRITTEN("7021","费用项目已核销"),
    NOT_FOUND_COST_PRO_SETTING_ITEM("7071", "当前用量未录入！"),
    
    //系统配置
    SYSTEM_CONFIG_ERROR_QUERY("9001","数据库中一个园区有且最多只能有一条配置信息，请联系相关技术人员"),
    SYSTEM_CONFIG_EXIST("9002","该园区的系统配置信息已经存在，不可重复创建"),
    SYSTEM_CONFIG_NOT_FOUND_BY_PARKID("9003","根据园区id未查询到记录"),
    SYSTEM_CONFIG_PARKID_IS_NULL("9004","园区id为空"),
    
    //入驻信息
    ENTER_INFO_PARAMS_IS_EMPTY("10001","参数为空"),
    ENTER_INFO_SMS_UNPASS("10002","验证码错误"),
    ENTER_INFO_IS_NOT_FOUND("10003","未找到记录"),
    ENTER_INFO_TREATMENTSTATUS_IS_WRONG("10004","处理类型取值错误"),
    ENTER_INFO_ILLEGAL_REQUEST("10005","非法请求，请正确访问符合用户身份的服务"),
    
    //服务订单
    APPLYORDER_UPDATE_ERROR("2101", "订单状态已改变。建议重新加载后重试。"),
    
    //修改手机号
    ADMIN_USER_CELLPHONE_ERROR_PLATFORM_SOURCE("11001","错误的平台来源"),
    ADMIN_USER_CELLPHONE_ERROR_OLDCELLPHONE("11002","旧手机号非用户对应手机号"),
    
    //统计
    STATISTICS_ITEM_NULL("12010","指定条件暂无元素！"),
    
    //未找到指定内容
    NOT_FOUND_ITEM("16001","未找到指定内容！"),
    
    CONTRACT_APPROVAL_ERROR("17010","您没有审批该合同的权限！"),
    BILL_APPROVAL_ERROR("17020","您没有审批该账单的权限！"),
    BILL_VERIFY_ERROR("17030","您没有核销该账单的权限！");

    

    private final String code;
    private final String message;

    private ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}