package com.sudaotech.huolijuzhen.commons.constant.notice;

public class NoticeConstants {
	
	
	//企业端
	public static class Enterprise{
		
		//企业账单
		public static class Bill{
	    	
			   public final static String  RECEIVED      =  "您收到新的企业账单！";
				
	    }
		
		//企业服务
		public static class Service{
			
			   public final static String  TREATED       =  "您的服务已处理，快去给服务商评价吧！";
			   
			   public final static String  CLOSED        =  "您的服务已被关闭，去看看原因吧！";
			   
			   public final static String  APPLY_PASS    =  "您的服务申请已通过！";
			   
			   public final static String  APPLY_FAIL    =  "您的服务申请未通过，快去看看原因吧！";
			
		}
		
		//社群活动
		public static class Activity{
			
			 public final static String  APPLY_PASS      =  "您的活动申请已通过！";
			 
			 public final static String  APPLY_FAIL      =  "您的活动申请未通过，快去看看原因吧！";
		
		}
		
		
		//园区关联
		public static class Cott{
			
			public final static String  COTT_ASK     =  "%s向您的企业发起业务关联请求，请处理！";
		}
		
		//维修申报
		public static class Task{
			public final static String TASK_COMMENT = "您的申报已处理，请为我们的服务进行评价吧！";
		}
		
		
	
	}
	
	//园区端
	public static class Park{
		
		//任务
		public static class Task{
			
			public final static String TASK_UPDATE = "您有任务已更新！";
			
			public final static String TASK_ARRIVE = "您有新的任务到达！";
			
			public final static String TASK_CLOSE = "您有任务已关闭！";
			
		}
		
	}
	
}
