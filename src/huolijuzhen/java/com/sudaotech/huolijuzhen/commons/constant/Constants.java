package com.sudaotech.huolijuzhen.commons.constant;

/**
 * 
 * @Describe:       系统常量设置
 *
 * @Author:			chenjs
 *
 * @Company:        kuaicto
 * 
 * @Project:        huolijuzhen
 *
 * @Package:        com.sudaotech.huolijuzhen.commons.constant
 *
 * @Date:           2016年11月21日 下午7:30:06
 *
 */

public class Constants {

	
	
	
	/**
	 * 平台
	 *
	 */
	public static class Platform {
		
		/**
		 * 平台系统管理员角色Id
		 */
	    public final static Long ADMIN_USER_ID = 10L;
	    
		/**
		 * 平台服务商前缀
		 */
		public final static String SERVER_USER_PREFIX="SP01";
     
    
	}
	
	/**
	 * 
	 * 园区
	 *
	 */
	public static class Park {
		
		/**
		 * 园区系统管理员角色Id
		 */
		public final static Long ADMIN_ROLE_ID=20L;

		
		/**
		 * 园区服务商角色Id
		 */
		public final static Long SERVICE_PROVIDER_ROLE_ID=23L;
		
		
		/**
		 * 园区组管理员角色Id
		 */
		public final static Long PARK_GROUP_ADMIN_ROLE_ID=24L;
		

		
		/**
		 * 园区系统管理员默认密码
		 */
		public final static String ADMIN_USER_PWD="111111";
		
		
		/**
		 * 园区组管理员默认密码
		 */
		public final static String PARK_GROUP_ADMIN_USER_PWD="333333";
		
		
		/**
		 * 服务商默认密码
		 */
		public final static String SERVER_USER_PWD="555555";
		
		/**
		 * 园区管理员前缀
		 */
		public final static String ADMIN_USER_PREFIX="P";
		
		/**
		 * 园区服务商前缀
		 */
		public final static String SERVER_USER_PREFIX="SP02";
		
		/**
		 * 账单编号前缀
		 */
	    public final static String BILL_NO_PREFIX="Bill";
	    
	    
	    /**
	     * 账单模板变量--账单期间
	     */
	    public final static String CONFIG_BILL_PERIOD="[Bill Period]";
	    
	    /**
	     * 账单模板变量--逾期天数
	     */
	    public final static String CONFIG_OVER_TIME="[Over Time]";
	    
	    
		
	}
	
	/**
	 * 企业
	 *
	 */
	public static class Enterprise {
		
		/**
		 * 企业管理员角色Id
		 */
		public final static Long ADMIN_ROLE_ID=30L;
		
		
		
		/**
		 * 企业用户默认密码
		 */
		public final static String ADMIN_USER_PWD="666666";
		
		
		/**
		 * 企业管理员前缀
		 */
		public final static String ADMIN_USER_PREFIX="E";
		
	}
	
	/**
	 * 通知
	 * @Describe:       
	 *
	 */
	public static class Notice{
		
		public final static String USER_PWD = "huolijuzhen#123456";
		
	}
	
	
	
}
