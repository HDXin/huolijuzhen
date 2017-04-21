package com.sudaotech;

import java.util.Map;

import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.c3p0.C3p0DataSourceProvider;

import com.github.pagehelper.PageHelper;
import com.google.inject.Scopes;
import com.google.inject.name.Names;
import com.sudaotech.account.dao.AccountMapper;
import com.sudaotech.account.dao.AuditStatusHandler;
import com.sudaotech.account.dao.LoginHistoryEntityMapper;
import com.sudaotech.account.dao.PermissionEntityMapper;
import com.sudaotech.account.dao.RoleEntityMapper;
import com.sudaotech.account.dao.RolePermissionEntityMapper;
import com.sudaotech.account.dao.UserPermissionEntityMapper;
import com.sudaotech.account.dao.UserRoleEntityMapper;
import com.sudaotech.account.service.AccountService;
import com.sudaotech.account.service.AccountServiceImpl;
import com.sudaotech.account.service.AdminAuthService;
import com.sudaotech.account.service.AdminAuthServiceImpl;
import com.sudaotech.account.service.AppAuthService;
import com.sudaotech.account.service.AppAuthServiceImpl;
import com.sudaotech.account.service.PermissionService;
import com.sudaotech.account.service.PermissionServiceImpl;
import com.sudaotech.account.service.RoleService;
import com.sudaotech.account.service.RoleServiceImpl;
import com.sudaotech.account.web.admin.AdminAuthResource;
import com.sudaotech.account.web.admin.AdminPasswordResource;
import com.sudaotech.account.web.admin.AdminPermissionResource;
import com.sudaotech.account.web.admin.AdminProfileResource;
import com.sudaotech.account.web.admin.AdminRoleResource;
import com.sudaotech.account.web.app.AppAuthResource;
import com.sudaotech.account.web.app.AppCellphoneResource;
import com.sudaotech.account.web.app.AppPasswordResource;
import com.sudaotech.account.web.app.AppProfileResource;
import com.sudaotech.account.web.app.AppRegisterResource;
import com.sudaotech.area.dao.AreaMapper;
import com.sudaotech.area.service.AreaService;
import com.sudaotech.area.service.AreaServiceImpl;
import com.sudaotech.area.web.AreaResource;
import com.sudaotech.cache.service.CacheService;
import com.sudaotech.cache.service.CacheServiceImpl;
import com.sudaotech.cache.web.CacheResource;
import com.sudaotech.captcha.service.CaptchaService;
import com.sudaotech.captcha.service.CaptchaServiceImpl;
import com.sudaotech.captcha.web.CaptchaResource;
import com.sudaotech.comment.dao.CommentEntityMapper;
import com.sudaotech.comment.service.CommentService;
import com.sudaotech.comment.service.CommentServiceImpl;
import com.sudaotech.comment.web.admin.AdminCommentResource;
import com.sudaotech.content.dao.ContentEntityMapper;
import com.sudaotech.content.service.ContentService;
import com.sudaotech.content.service.ContentServiceImpl;
import com.sudaotech.content.web.admin.ContentResource;
import com.sudaotech.content.web.admin.ContentTagResource;
import com.sudaotech.core.config.ConfigLoader;
import com.sudaotech.core.dao.handler.GenderHandler;
import com.sudaotech.core.dao.handler.StatusHandler;
import com.sudaotech.core.dao.handler.TypeHandlerImpl;
import com.sudaotech.core.dao.interceptor.DeleteDisabledInterceptor;
import com.sudaotech.core.enums.AuditStatus;
import com.sudaotech.core.enums.Gender;
import com.sudaotech.core.enums.PlatformSource;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.enums.Type;
import com.sudaotech.core.enums.handler.PlatformSourceHandler;
import com.sudaotech.core.mapper.SequenceMapper;
import com.sudaotech.core.service.BlackWordsService;
import com.sudaotech.core.service.BlackWordsServiceImpl;
import com.sudaotech.core.service.SessionService;
import com.sudaotech.core.service.SessionServiceImpl;
import com.sudaotech.event.service.NotifyService;
import com.sudaotech.event.service.NotifyServiceAsyncImpl;
import com.sudaotech.feedback.dao.FeedbackEntityMapper;
import com.sudaotech.feedback.service.FeedbackService;
import com.sudaotech.feedback.service.FeedbackServiceImpl;
import com.sudaotech.feedback.web.admin.AdminFeedbackResource;
import com.sudaotech.file.service.FileStorageService;
import com.sudaotech.file.service.FileStorageServiceImpl;
import com.sudaotech.file.web.FileResource;
import com.sudaotech.image.service.ImageService;
import com.sudaotech.image.service.ImageServiceImpl;
import com.sudaotech.image.web.ImageResource;
import com.sudaotech.message.MsgBizType;
import com.sudaotech.message.MsgStatus;
import com.sudaotech.message.dao.MsgBizTypeHandler;
import com.sudaotech.message.dao.MsgStatusHandler;
import com.sudaotech.mobile.web.MobileAppUpdateResource;
import com.sudaotech.node.dao.NodeEntityMapper;
import com.sudaotech.node.service.NodeService;
import com.sudaotech.node.service.NodeServiceImpl;
import com.sudaotech.note.dao.NoteEntityMapper;
import com.sudaotech.note.service.NoteService;
import com.sudaotech.note.service.NoteServiceImpl;
import com.sudaotech.note.web.NoteResource;
import com.sudaotech.picture.dao.PictureEntityMapper;
import com.sudaotech.redis.service.RedisCacheService;
import com.sudaotech.redis.service.RedisCacheServiceImpl;
import com.sudaotech.redis.service.RedisService;
import com.sudaotech.redis.service.RedisServiceImpl;
import com.sudaotech.redis.service.RedisStoreService;
import com.sudaotech.redis.service.RedisStoreServiceImpl;
import com.sudaotech.sequence.service.SequenceService;
import com.sudaotech.sequence.service.SequenceServiceImpl;
import com.sudaotech.share.dao.ShareEntityMapper;
import com.sudaotech.share.service.ShareService;
import com.sudaotech.share.service.ShareServiceImpl;
import com.sudaotech.share.web.app.AppShareResource;
import com.sudaotech.shipping.dao.ShippingEntityMapper;
import com.sudaotech.sms.SmsStatus;
import com.sudaotech.sms.dao.SmsHistoryEntityMapper;
import com.sudaotech.sms.dao.SmsStatusHandler;
import com.sudaotech.sms.service.PhoneCodeService;
import com.sudaotech.sms.service.PhoneCodeServiceImpl;
import com.sudaotech.sms.service.SmsService;
import com.sudaotech.sms.service.SmsServiceZZImpl;
import com.sudaotech.sms.web.PhoneCodeResource;
import com.sudaotech.sms.web.SmsResource;
import com.sudaotech.tag.dao.TagEntityMapper;
import com.sudaotech.tag.service.TagService;
import com.sudaotech.tag.service.TagServiceImpl;
import com.sudaotech.tag.web.admin.TagResource;
import com.sudaotech.tracking.dao.TrackingEntityMapper;
import com.sudaotech.tracking.service.TrackingService;
import com.sudaotech.tracking.service.TrackingServiceImpl;
import com.sudaotech.user.dao.AppUserEntityMapper;
import com.sudaotech.user.dao.ExternalUserEntityMapper;
import com.sudaotech.user.dao.handler.LocationAdminUserEntityMapper;
import com.sudaotech.user.dao.handler.PasswordStatusHandler;
import com.sudaotech.user.dao.handler.UserStatusHandler;
import com.sudaotech.user.enums.PasswordStatus;
import com.sudaotech.user.enums.UserStatus;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserServiceImpl;
import com.sudaotech.user.service.AppUserService;
import com.sudaotech.user.service.AppUserServiceImpl;
import com.sudaotech.user.service.ExternalUserService;
import com.sudaotech.user.service.ExternalUserServiceImpl;
import com.sudaotech.user.web.admin.AdminUserResource;

/**
 * 基础框架模块集
 */
public class BaseModule extends MyBatisModule {

    @Override
    protected void initialize() {
        initEnvModule(); // 环境模块
        initBasicModule(); // 基础模块
        initMobileAppModule(); // mobile app基础模块
        initSequenceModule();
        initAccountModule(); // 账户
//        initContentModule(); // 内容
//        initTagModule(); // 标签
//        initFeedbackModule(); // 反馈
        initAreaModule(); // 区域省市区
        initCacheModule(); // 缓存
//        initCompanyModule(); // 公司
        initFileModule(); // 文件
//        initMessageModule(); // 消息
//        initNodeModule(); // 节点
        initCommentModule(); //评论
//        initNoteModule(); // 备注
//        initPictureModule(); // 图片数据
        initSessionModule();
//        initShippingModule(); // 发货 
        initSmsModule(); // 短信
        initTrackingModule(); // tracking
        initUserModule(); // 用户
        initImageModule(); // 图像处理
//        initShareModule(); //分享
    }
    private void initMobileAppModule() {
        // web
        bind(MobileAppUpdateResource.class);
    }

    private void initBasicModule() {
        bind(NotifyService.class).to(NotifyServiceAsyncImpl.class).in(Scopes.SINGLETON);
        bind(BlackWordsService.class).to(BlackWordsServiceImpl.class).in(Scopes.SINGLETON);
    }
    
    private void initSessionModule() {
        bind(SessionService.class).to(SessionServiceImpl.class).in(Scopes.SINGLETON);        
    }

    private void initTrackingModule() {
        // service
        bind(TrackingService.class).to(TrackingServiceImpl.class).in(Scopes.SINGLETON);
        // dao
        addMapperClass(TrackingEntityMapper.class);
    }
    private void initContentModule() {
        // web
        bind(ContentResource.class);
        bind(ContentTagResource.class);
        // service
        bind(ContentService.class).to(ContentServiceImpl.class).in(Scopes.SINGLETON);
        // dao
        addMapperClass(ContentEntityMapper.class);
    }
    private void initTagModule() {
        // web
        bind(TagResource.class);
        // service
        bind(TagService.class).to(TagServiceImpl.class).in(Scopes.SINGLETON);
        // dao
        addMapperClass(TagEntityMapper.class);
    }
    private void initFeedbackModule() {
        // web
        bind(AdminFeedbackResource.class);
        // service
        bind(FeedbackService.class).to(FeedbackServiceImpl.class).in(Scopes.SINGLETON);
        // dao
        addMapperClass(FeedbackEntityMapper.class);
    }
    
    private void initShareModule() {
        // web
        bind(AppShareResource.class);
        // service
        bind(ShareService.class).to(ShareServiceImpl.class).in(Scopes.SINGLETON);
        // dao
        addMapperClass(ShareEntityMapper.class);
    }

    private void initCacheModule() {
        bind(CacheService.class).to(CacheServiceImpl.class).in(Scopes.SINGLETON);
        bind(RedisService.class).to(RedisServiceImpl.class).in(Scopes.SINGLETON);
        bind(RedisStoreService.class).to(RedisStoreServiceImpl.class).in(Scopes.SINGLETON);
        bind(RedisCacheService.class).to(RedisCacheServiceImpl.class).in(Scopes.SINGLETON);
        
        bind(CacheResource.class);
    }

    private void initUserModule() {
        addMapperClass(LocationAdminUserEntityMapper.class);
        addMapperClass(AppUserEntityMapper.class);
        addMapperClass(ExternalUserEntityMapper.class);
        
        this.handleType(UserStatus.class).with(UserStatusHandler.class);
        this.handleType(PasswordStatus.class).with(PasswordStatusHandler.class);
        this.handleType(Type.class).with(TypeHandlerImpl.class);
        this.handleType(PlatformSource.class).with(PlatformSourceHandler.class);
        
        bind(AdminUserService.class).to(AdminUserServiceImpl.class).in(Scopes.SINGLETON);
        bind(AppUserService.class).to(AppUserServiceImpl.class).in(Scopes.SINGLETON);
        bind(ExternalUserService.class).to(ExternalUserServiceImpl.class).in(Scopes.SINGLETON);

        bind(AdminUserResource.class);
    }

    private void initSmsModule() {
        addMapperClass(SmsHistoryEntityMapper.class);

        this.handleType(SmsStatus.class).with(SmsStatusHandler.class);
        
        bind(PhoneCodeService.class).to(PhoneCodeServiceImpl.class).in(Scopes.SINGLETON);
        bind(SmsService.class).to(SmsServiceZZImpl.class).in(Scopes.SINGLETON);
        
        bind(PhoneCodeResource.class);
        bind(SmsResource.class);
    }

    private void initShippingModule() {
        addMapperClass(ShippingEntityMapper.class);        
    }

    private void initSequenceModule() {
        // service
        bind(SequenceService.class).to(SequenceServiceImpl.class).in(Scopes.SINGLETON);

        // dao
        addMapperClass(SequenceMapper.class);
    }

    private void initPictureModule() {
        addMapperClass(PictureEntityMapper.class);        
    }

    private void initCommentModule() {
        addMapperClass(CommentEntityMapper.class);
        
        bind(CommentService.class).to(CommentServiceImpl.class).in(Scopes.SINGLETON);
        
        bind(AdminCommentResource.class);
    }

    private void initNoteModule() {
        addMapperClass(NoteEntityMapper.class);
        
        bind(NoteService.class).to(NoteServiceImpl.class).in(Scopes.SINGLETON);
        
        bind(NoteResource.class);
    }

    private void initNodeModule() {
        addMapperClass(NodeEntityMapper.class);
        bind(NodeService.class).to(NodeServiceImpl.class).in(Scopes.SINGLETON);
    }

    private void initMessageModule() {
        
        this.handleType(MsgStatus.class).with(MsgStatusHandler.class);
        this.handleType(MsgBizType.class).with(MsgBizTypeHandler.class);
    }

    private void initFileModule() {
    	
    	 bind(FileResource.class);
    	 bind(FileStorageService.class).to(FileStorageServiceImpl.class).in(Scopes.SINGLETON);
    	     
    }

    private void initCompanyModule() {
        //addMapperClass(CompanyMapper.class);
        
       // bind(CompanyService.class).to(CompanyServiceImpl.class).in(Scopes.SINGLETON);
    }

    private void initAreaModule() {
        addMapperClass(AreaMapper.class);
        
        bind(AreaService.class).to(AreaServiceImpl.class).in(Scopes.SINGLETON);
        
        bind(AreaResource.class);
    }

    private void initAccountModule() {
        addMapperClass(PermissionEntityMapper.class);
        addMapperClass(RoleEntityMapper.class);
        addMapperClass(RolePermissionEntityMapper.class);
        addMapperClass(UserRoleEntityMapper.class);
        addMapperClass(UserPermissionEntityMapper.class);
        addMapperClass(LoginHistoryEntityMapper.class);
        addMapperClass(AccountMapper.class);
        
     
        bind(AccountService.class).to(AccountServiceImpl.class).in(Scopes.SINGLETON);
        bind(AppAuthService.class).to(AppAuthServiceImpl.class).in(Scopes.SINGLETON);
        bind(AdminAuthService.class).to(AdminAuthServiceImpl.class).in(Scopes.SINGLETON);
        bind(PermissionService.class).to(PermissionServiceImpl.class).in(Scopes.SINGLETON);
        bind(RoleService.class).to(RoleServiceImpl.class).in(Scopes.SINGLETON);
        
        bind(AppCellphoneResource.class);
        bind(AppPasswordResource.class);
        bind(AppRegisterResource.class);
        bind(AppAuthResource.class);
        bind(AppProfileResource.class);
        bind(AdminAuthResource.class);
        bind(AdminProfileResource.class);
        bind(AdminPermissionResource.class);
        bind(AdminRoleResource.class);
        bind(AdminPasswordResource.class);
    }

    private void initEnvModule() {
        // 加载环境配置
        Map<String, String> envConfig = ConfigLoader.loadEnvConfig();
        Names.bindProperties(binder(), envConfig);
        
        
        //        install(JdbcHelper.MySQL);
        //        bindDataSourceProviderType(PooledDataSourceProvider.class);
        bindDataSourceProviderType(C3p0DataSourceProvider.class);
        bindTransactionFactoryType(JdbcTransactionFactory.class);
        
        // 开发前期暂时不用
        //        addInterceptorClass(WhereRequiredInterceptor.class);
        //        addInterceptorClass(SelectInterceptor.class); //SelectInterceptor用于开发和测试阶段分析问题，生产环境慎用
        //        addInterceptorClass(UpdateVersionFieldInterceptor.class);
        addInterceptorClass(DeleteDisabledInterceptor.class);

        // type handler
        this.handleType(Status.class).with(StatusHandler.class);
        this.handleType(AuditStatus.class).with(AuditStatusHandler.class);
        this.handleType(Gender.class).with(GenderHandler.class);
        
        // intercepter
        // TODO 待权限管理模块完成后，开启如下校验
        // bindInterceptor(Matchers.any(), Matchers.annotatedWith(RequirePermission.class), new RequirePermissionInterceptor());
        addInterceptorClass(PageHelper.class);
    }

    private void initImageModule() {
        // web
        bind(ImageResource.class);
        
        // service
        bind(ImageService.class).to(ImageServiceImpl.class).in(Scopes.SINGLETON);
    }
}
