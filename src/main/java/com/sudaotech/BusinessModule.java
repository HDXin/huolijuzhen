package com.sudaotech;

import com.google.inject.Scopes;
import com.sudaotech.account.web.admin.AdminCellphoneResource;
import com.sudaotech.area.service.AreaService;
import com.sudaotech.area.service.AreaServiceImpl;
import com.sudaotech.huolijuzhen.announcement.dao.AnnouncementEntityMapper;
import com.sudaotech.huolijuzhen.announcement.service.AnnouncementService;
import com.sudaotech.huolijuzhen.announcement.service.AnnouncementServiceImpl;
import com.sudaotech.huolijuzhen.announcement.web.admin.park.AdminParkAnnouncementResource;
import com.sudaotech.huolijuzhen.announcement.web.admin.platform.AdminPlatformAnnouncementResource;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalProcessEntityExample;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalProcessEntityMapper;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalRecordEntityMapper;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalTypeEntityMapper;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalTypeItemEntityMapper;
import com.sudaotech.huolijuzhen.approval.service.ApprovalProcessService;
import com.sudaotech.huolijuzhen.approval.service.ApprovalProcessServiceImpl;
import com.sudaotech.huolijuzhen.approval.service.ApprovalRecordService;
import com.sudaotech.huolijuzhen.approval.service.ApprovalRecordServiceImpl;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeItemService;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeItemServiceImpl;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeService;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeServiceImpl;
import com.sudaotech.huolijuzhen.approval.web.admin.park.AdminParkApprovalProcessResource;
import com.sudaotech.huolijuzhen.approval.web.admin.park.AdminParkApprovalRecordResource;
import com.sudaotech.huolijuzhen.approval.web.admin.park.AdminParkApprovalTypeItemResource;
import com.sudaotech.huolijuzhen.approval.web.admin.park.AdminParkApprovalTypeResource;
import com.sudaotech.huolijuzhen.approval.web.app.park.AppParkApprovalProcessResource;
import com.sudaotech.huolijuzhen.approval.web.app.park.AppParkApprovalRecordResource;
import com.sudaotech.huolijuzhen.approval.web.app.park.AppParkApprovalTypeItemResource;
import com.sudaotech.huolijuzhen.approval.web.app.park.AppParkApprovalTypeResource;
import com.sudaotech.huolijuzhen.bannerManager.dao.BannerSourcesEntityMapper;
import com.sudaotech.huolijuzhen.basic.dao.GenCodeMapper;
import com.sudaotech.huolijuzhen.basic.dao.LocationServiceScenarioEntityMapper;
import com.sudaotech.huolijuzhen.basic.dao.LocationServiceTypeEntityMapper;
import com.sudaotech.huolijuzhen.basic.dao.ParkGroupParkInfoMapper;
import com.sudaotech.huolijuzhen.basic.dao.ParkGroupUserMapper;
import com.sudaotech.huolijuzhen.basic.dao.ServiceLocationEntityMapper;
import com.sudaotech.huolijuzhen.basic.dao.SystemConfigEntityExtendsMapper;
import com.sudaotech.huolijuzhen.basic.service.BannerSourcesService;
import com.sudaotech.huolijuzhen.basic.service.BannerSourcesServiceImpl;
import com.sudaotech.huolijuzhen.basic.service.CostProService;
import com.sudaotech.huolijuzhen.basic.service.CostProServiceImpl;
import com.sudaotech.huolijuzhen.basic.service.GenCodeService;
import com.sudaotech.huolijuzhen.basic.service.GenCodeServiceImpl;
import com.sudaotech.huolijuzhen.basic.service.LocationService;
import com.sudaotech.huolijuzhen.basic.service.LocationServiceImpl;
import com.sudaotech.huolijuzhen.basic.service.MessageService;
import com.sudaotech.huolijuzhen.basic.service.MessageServiceImpl;
import com.sudaotech.huolijuzhen.basic.service.ServiceScenarioService;
import com.sudaotech.huolijuzhen.basic.service.ServiceScenarioServiceImpl;
import com.sudaotech.huolijuzhen.basic.service.ServiceTypeService;
import com.sudaotech.huolijuzhen.basic.service.ServiceTypeServiceImpl;
import com.sudaotech.huolijuzhen.basic.service.SystemConfigService;
import com.sudaotech.huolijuzhen.basic.service.SystemConfigServiceImpl;
import com.sudaotech.huolijuzhen.basic.web.admin.park.SystemConfigResource;
import com.sudaotech.huolijuzhen.basic.web.admin.platform.CostProResource;
import com.sudaotech.huolijuzhen.basic.web.admin.platform.LocationResource;
import com.sudaotech.huolijuzhen.basic.web.admin.platform.ServiceScenarioResource;
import com.sudaotech.huolijuzhen.basic.web.admin.platform.ServiceTypeResource;
import com.sudaotech.huolijuzhen.basic.web.app.enterprise.BannerSourcesInnerServiceResource;
import com.sudaotech.huolijuzhen.bill.dao.BillCcrAdjEntityMapper;
import com.sudaotech.huolijuzhen.bill.dao.BillChangeLogsEntityMapper;
import com.sudaotech.huolijuzhen.bill.dao.BillCollectionRecordMapper;
import com.sudaotech.huolijuzhen.bill.dao.BillCostCalRulesEntityMapper;
import com.sudaotech.huolijuzhen.bill.dao.BillCostDetailMapper;
import com.sudaotech.huolijuzhen.bill.dao.BillInfoMapper;
import com.sudaotech.huolijuzhen.bill.dao.BillPayVoucherEntityMapper;
import com.sudaotech.huolijuzhen.bill.dao.CostProEntityMapper;
import com.sudaotech.huolijuzhen.bill.dao.CostProSettingEntityMapper;
import com.sudaotech.huolijuzhen.bill.dao.RollPeriodEntityMapper;
import com.sudaotech.huolijuzhen.bill.service.BillCcrAdjService;
import com.sudaotech.huolijuzhen.bill.service.BillCcrAdjServiceImpl;
import com.sudaotech.huolijuzhen.bill.service.BillChangeLogsService;
import com.sudaotech.huolijuzhen.bill.service.BillChangeLogsServiceImpl;
import com.sudaotech.huolijuzhen.bill.service.BillCollectionRecordService;
import com.sudaotech.huolijuzhen.bill.service.BillCollectionRecordServiceImpl;
import com.sudaotech.huolijuzhen.bill.service.BillCostCalRulesService;
import com.sudaotech.huolijuzhen.bill.service.BillCostCalRulesServiceImpl;
import com.sudaotech.huolijuzhen.bill.service.BillCostDetailService;
import com.sudaotech.huolijuzhen.bill.service.BillCostDetailServiceImpl;
import com.sudaotech.huolijuzhen.bill.service.BillInfoService;
import com.sudaotech.huolijuzhen.bill.service.BillInfoServiceImpl;
import com.sudaotech.huolijuzhen.bill.service.BillPayVoucherService;
import com.sudaotech.huolijuzhen.bill.service.BillPayVoucherServiceImpl;
import com.sudaotech.huolijuzhen.bill.service.CostProSettingService;
import com.sudaotech.huolijuzhen.bill.service.CostProSettingServiceImpl;
import com.sudaotech.huolijuzhen.bill.service.RollPeriodService;
import com.sudaotech.huolijuzhen.bill.service.RollPeriodServiceImpl;
import com.sudaotech.huolijuzhen.bill.web.admin.park.BillCcrAdjResource;
import com.sudaotech.huolijuzhen.bill.web.admin.park.BillChangeLogsResource;
import com.sudaotech.huolijuzhen.bill.web.admin.park.BillCollectionRecordResource;
import com.sudaotech.huolijuzhen.bill.web.admin.park.BillCostCalRulesResource;
import com.sudaotech.huolijuzhen.bill.web.admin.park.BillCostDetailResource;
import com.sudaotech.huolijuzhen.bill.web.admin.park.BillInfoResource;
import com.sudaotech.huolijuzhen.bill.web.admin.park.CostProSettingResource;
import com.sudaotech.huolijuzhen.bill.web.admin.park.RollPeriodResource;
import com.sudaotech.huolijuzhen.community.dao.EnterpriseDisplayEntityExtendsMapper;
import com.sudaotech.huolijuzhen.community.dao.LocationCommunityApplyEntityMapper;
import com.sudaotech.huolijuzhen.community.dao.LocationCommunityEntityMapper;
import com.sudaotech.huolijuzhen.community.service.CommunityApplyService;
import com.sudaotech.huolijuzhen.community.service.CommunityApplyServiceImpl;
import com.sudaotech.huolijuzhen.community.service.CommunityService;
import com.sudaotech.huolijuzhen.community.service.CommunityServiceImpl;
import com.sudaotech.huolijuzhen.community.service.EnterpriseDisplayService;
import com.sudaotech.huolijuzhen.community.service.EnterpriseDisplayServiceImpl;
import com.sudaotech.huolijuzhen.community.web.admin.enterprise.AdminEnterpriseCommunityApplyResource;
import com.sudaotech.huolijuzhen.community.web.admin.enterprise.AdminEnterpriseCommunityResource;
import com.sudaotech.huolijuzhen.community.web.admin.park.AdminParkCommunityApplyResource;
import com.sudaotech.huolijuzhen.community.web.admin.park.AdminParkCommunityResource;
import com.sudaotech.huolijuzhen.community.web.admin.platform.AdminPlatformCommunityApplyResource;
import com.sudaotech.huolijuzhen.community.web.admin.platform.AdminPlatformCommunityResource;
import com.sudaotech.huolijuzhen.community.web.app.enterprise.AppEnterpriseCommunityApplyResource;
import com.sudaotech.huolijuzhen.community.web.app.enterprise.AppEnterpriseCommunityResource;
import com.sudaotech.huolijuzhen.dao.MessageEntityMapper;
import com.sudaotech.huolijuzhen.dao.ParkGroupInfoEntityMapper;
import com.sudaotech.huolijuzhen.dao.ResInfoEntityMapper;
import com.sudaotech.huolijuzhen.dao.UnitTierInfoEntityMapper;
import com.sudaotech.huolijuzhen.enter.dao.EnterInfoEntityMapper;
import com.sudaotech.huolijuzhen.enter.service.EnterInfoService;
import com.sudaotech.huolijuzhen.enter.service.EnterInfoServiceImpl;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractBillEntityMapper;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractDossierEntityMapper;
import com.sudaotech.huolijuzhen.enterprise.dao.LocationContractInfoEntityMapper;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractResourceEntityMapper;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCorrBusinessEntityMapper;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCorrContractEntityMapper;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCottMapper;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseDossierEntityMapper;
import com.sudaotech.huolijuzhen.enterprise.dao.LocationEnterpriseInfoEntityMapper;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseUserCottEntityMapper;
import com.sudaotech.huolijuzhen.enterprise.service.ContractBillService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractBillServiceImpl;
import com.sudaotech.huolijuzhen.enterprise.service.ContractDossierService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractDossierServiceImpl;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoServiceImpl;
import com.sudaotech.huolijuzhen.enterprise.service.ContractResourceService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractResourceServiceImpl;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrBusinessService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrBusinessServiceImpl;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrContractService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrContractServiceImpl;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottServiceImpl;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseDossierService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseDossierServiceImpl;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoServiceImpl;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseUserCottService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseUserCottServiceImpl;
import com.sudaotech.huolijuzhen.enterprise.web.admin.park.ContractBillResource;
import com.sudaotech.huolijuzhen.enterprise.web.admin.park.ContractInfoResource;
import com.sudaotech.huolijuzhen.enterprise.web.admin.park.ContractResourceResource;
import com.sudaotech.huolijuzhen.enterprise.web.admin.park.EnterpriseCorrBusinessResource;
import com.sudaotech.huolijuzhen.enterprise.web.admin.park.EnterpriseCorrContractResource;
import com.sudaotech.huolijuzhen.enterprise.web.admin.park.EnterpriseCottResource;
import com.sudaotech.huolijuzhen.enterprise.web.admin.park.EnterpriseDossierResource;
import com.sudaotech.huolijuzhen.enterprise.web.admin.park.EnterpriseInfoResource;
import com.sudaotech.huolijuzhen.enterprise.web.admin.park.EnterpriseUserCottResource;
import com.sudaotech.huolijuzhen.enums.ApplyOrderStatus;
import com.sudaotech.huolijuzhen.enums.ApplyOrderType;
import com.sudaotech.huolijuzhen.enums.ApprovalProcessStatus;
import com.sudaotech.huolijuzhen.enums.ApprovalStatus;
import com.sudaotech.huolijuzhen.enums.ApprovalType;
import com.sudaotech.huolijuzhen.enums.BillApprovalStatus;
import com.sudaotech.huolijuzhen.enums.BillConfirmStatus;
import com.sudaotech.huolijuzhen.enums.BillOperType;
import com.sudaotech.huolijuzhen.enums.BillPushStatus;
import com.sudaotech.huolijuzhen.enums.BillStatus;
import com.sudaotech.huolijuzhen.enums.BillSubmitStatus;
import com.sudaotech.huolijuzhen.enums.BillUrgePushStatus;
import com.sudaotech.huolijuzhen.enums.BillVerificationStatus;
import com.sudaotech.huolijuzhen.enums.BusinessType;
import com.sudaotech.huolijuzhen.enums.CalcDimension;
import com.sudaotech.huolijuzhen.enums.CellphoneParams;
import com.sudaotech.huolijuzhen.enums.ChargeMode;
import com.sudaotech.huolijuzhen.enums.ChooseStatus;
import com.sudaotech.huolijuzhen.enums.CommentGrade;
import com.sudaotech.huolijuzhen.enums.ComputeMode;
import com.sudaotech.huolijuzhen.enums.ContractStatus;
import com.sudaotech.huolijuzhen.enums.CorrStatus;
import com.sudaotech.huolijuzhen.enums.CorrType;
import com.sudaotech.huolijuzhen.enums.CreateSide;
import com.sudaotech.huolijuzhen.enums.CreateSource;
import com.sudaotech.huolijuzhen.enums.CycleType;
import com.sudaotech.huolijuzhen.enums.EnableAvg;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.enums.EntryType;
import com.sudaotech.huolijuzhen.enums.FileType;
import com.sudaotech.huolijuzhen.enums.Grade;
import com.sudaotech.huolijuzhen.enums.ImageType;
import com.sudaotech.huolijuzhen.enums.LabelType;
import com.sudaotech.huolijuzhen.enums.OperatorType;
import com.sudaotech.huolijuzhen.enums.PayChannels;
import com.sudaotech.huolijuzhen.enums.PayWay;
import com.sudaotech.huolijuzhen.enums.PlanStatus;
import com.sudaotech.huolijuzhen.enums.PublicGrade;
import com.sudaotech.huolijuzhen.enums.ReqSourceType;
import com.sudaotech.huolijuzhen.enums.ResType;
import com.sudaotech.huolijuzhen.enums.SendGrade;
import com.sudaotech.huolijuzhen.enums.ServerGrade;
import com.sudaotech.huolijuzhen.enums.ServiceApprovalStatus;
import com.sudaotech.huolijuzhen.enums.ServiceGrade;
import com.sudaotech.huolijuzhen.enums.SuccessOrFailEnums;
import com.sudaotech.huolijuzhen.enums.TaskStatus;
import com.sudaotech.huolijuzhen.enums.TaskType;
import com.sudaotech.huolijuzhen.enums.TransDirectionType;
import com.sudaotech.huolijuzhen.enums.TransactionType;
import com.sudaotech.huolijuzhen.enums.TransferSourceType;
import com.sudaotech.huolijuzhen.enums.TreatmentStatus;
import com.sudaotech.huolijuzhen.enums.UseStatus;
import com.sudaotech.huolijuzhen.equipment.dao.EquipmentPlanEntityMapper;
import com.sudaotech.huolijuzhen.equipment.dao.LocationEquipmentPlanEntityMapper;
import com.sudaotech.huolijuzhen.equipment.dao.LocationEquipmentPreserveEntityMapper;
import com.sudaotech.huolijuzhen.equipment.dao.LocationEquipmentTypeEntityMapper;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPlanService;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPlanServiceImpl;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPreserveService;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPreserveServiceImpl;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentTypeService;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentTypeServiceImpl;
import com.sudaotech.huolijuzhen.equipment.web.admin.park.EquipmentPlanResource;
import com.sudaotech.huolijuzhen.equipment.web.admin.park.EquipmentPreserveResource;
import com.sudaotech.huolijuzhen.equipment.web.admin.park.EquipmentTypeResource;
import com.sudaotech.huolijuzhen.equipment.web.app.tenement.AppTenementEquipmentTypeResource;
import com.sudaotech.huolijuzhen.handler.ApplyOrderStatusHandler;
import com.sudaotech.huolijuzhen.handler.ApplyOrderTypeHandler;
import com.sudaotech.huolijuzhen.handler.ApprovalProcessStatusHandler;
import com.sudaotech.huolijuzhen.handler.ApprovalStatusHandler;
import com.sudaotech.huolijuzhen.handler.ApprovalTypeHandler;
import com.sudaotech.huolijuzhen.handler.BillApprovalStatusHandler;
import com.sudaotech.huolijuzhen.handler.BillConfirmStatusHandler;
import com.sudaotech.huolijuzhen.handler.BillOperTypeHandler;
import com.sudaotech.huolijuzhen.handler.BillPushStatusHandler;
import com.sudaotech.huolijuzhen.handler.BillStatusHandler;
import com.sudaotech.huolijuzhen.handler.BillSubmitStatusHandler;
import com.sudaotech.huolijuzhen.handler.BillUrgePushStatusHandler;
import com.sudaotech.huolijuzhen.handler.BillVerificationStatusHandler;
import com.sudaotech.huolijuzhen.handler.BusinessTypeHandler;
import com.sudaotech.huolijuzhen.handler.CalcDimensionHandler;
import com.sudaotech.huolijuzhen.handler.CellphomeParamsHandler;
import com.sudaotech.huolijuzhen.handler.ChargeModeHandler;
import com.sudaotech.huolijuzhen.handler.ChooseStatusHandler;
import com.sudaotech.huolijuzhen.handler.CommentGradeHandler;
import com.sudaotech.huolijuzhen.handler.ComputeModeHandler;
import com.sudaotech.huolijuzhen.handler.ContractStatusHandler;
import com.sudaotech.huolijuzhen.handler.CorrStatusHandler;
import com.sudaotech.huolijuzhen.handler.CorrTypeHandler;
import com.sudaotech.huolijuzhen.handler.CreateSideHandler;
import com.sudaotech.huolijuzhen.handler.CreateSourceHandler;
import com.sudaotech.huolijuzhen.handler.CycleTypeHandler;
import com.sudaotech.huolijuzhen.handler.EnableAvgHandler;
import com.sudaotech.huolijuzhen.handler.EnableStatusHandler;
import com.sudaotech.huolijuzhen.handler.EntryTypeHandler;
import com.sudaotech.huolijuzhen.handler.FileTypeHandler;
import com.sudaotech.huolijuzhen.handler.GradeHandler;
import com.sudaotech.huolijuzhen.handler.ImageTypeHandler;
import com.sudaotech.huolijuzhen.handler.LabelTypeHandler;
import com.sudaotech.huolijuzhen.handler.OperatorTypeHandler;
import com.sudaotech.huolijuzhen.handler.PayChannelsHandler;
import com.sudaotech.huolijuzhen.handler.PayWayHandler;
import com.sudaotech.huolijuzhen.handler.PlanStatusHandler;
import com.sudaotech.huolijuzhen.handler.PublicGradeHandler;
import com.sudaotech.huolijuzhen.handler.ReqSourceTypeHandler;
import com.sudaotech.huolijuzhen.handler.ResTypeHandler;
import com.sudaotech.huolijuzhen.handler.SendGradeHandler;
import com.sudaotech.huolijuzhen.handler.ServerGradeHandler;
import com.sudaotech.huolijuzhen.handler.ServiceApprovalStatusHandler;
import com.sudaotech.huolijuzhen.handler.SuccessOrFailEnumsHandler;
import com.sudaotech.huolijuzhen.handler.TaskStatusHandler;
import com.sudaotech.huolijuzhen.handler.TaskTypeHandler;
import com.sudaotech.huolijuzhen.handler.TransDirectionTypeHandler;
import com.sudaotech.huolijuzhen.handler.TransactionTypeHandler;
import com.sudaotech.huolijuzhen.handler.TransferSourceTypeHandler;
import com.sudaotech.huolijuzhen.handler.TreatmentStatusHandler;
import com.sudaotech.huolijuzhen.handler.UseStatusHandler;
import com.sudaotech.huolijuzhen.handler.serviceGradeHandler;
import com.sudaotech.huolijuzhen.notice.service.NoticeEnterpriseService;
import com.sudaotech.huolijuzhen.notice.service.NoticeEnterpriseServiceImpl;
import com.sudaotech.huolijuzhen.notice.service.NoticeParkService;
import com.sudaotech.huolijuzhen.notice.service.NoticeParkServiceImpl;
import com.sudaotech.huolijuzhen.notice.web.AssemblyMessageResouce;
import com.sudaotech.huolijuzhen.park.dao.LocationParkInfoEntityMapper;
import com.sudaotech.huolijuzhen.park.service.ParkGroupInfoService;
import com.sudaotech.huolijuzhen.park.service.ParkGroupInfoServiceImpl;
import com.sudaotech.huolijuzhen.park.service.ParkGroupParkInfoService;
import com.sudaotech.huolijuzhen.park.service.ParkGroupParkInfoServiceImpl;
import com.sudaotech.huolijuzhen.park.service.ParkGroupUserInfoService;
import com.sudaotech.huolijuzhen.park.service.ParkGroupUserInfoServiceImpl;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService;
import com.sudaotech.huolijuzhen.park.service.ParkInfoServiceImpl;
import com.sudaotech.huolijuzhen.park.web.admin.platform.ParkGroupInfoResource;
import com.sudaotech.huolijuzhen.park.web.admin.platform.ParkGroupParkInfoResource;
import com.sudaotech.huolijuzhen.park.web.admin.platform.ParkGroupUserInfoResource;
import com.sudaotech.huolijuzhen.park.web.admin.platform.ParkInfoResource;
import com.sudaotech.huolijuzhen.payment.service.PaymentService;
import com.sudaotech.huolijuzhen.payment.service.PaymentServiceImpl;
import com.sudaotech.huolijuzhen.payment.web.PaymentResource;
import com.sudaotech.huolijuzhen.policy.dao.LocationPolicyEntityMapper;
import com.sudaotech.huolijuzhen.policy.service.PolicyService;
import com.sudaotech.huolijuzhen.policy.service.PolicyServiceImpl;
import com.sudaotech.huolijuzhen.policy.web.admin.enterprise.AdminEnterprisePolicyResource;
import com.sudaotech.huolijuzhen.policy.web.admin.platform.AdminPlatformPolicyResource;
import com.sudaotech.huolijuzhen.provider.dao.ApplyLabelEntityMapper;
import com.sudaotech.huolijuzhen.provider.dao.ApplyTemplateEntityMapper;
import com.sudaotech.huolijuzhen.provider.dao.LocationApplyOrderEntityMapper;
import com.sudaotech.huolijuzhen.provider.dao.LocationServiceCollectEntityMapper;
import com.sudaotech.huolijuzhen.provider.dao.LocationServiceCommentEntityMapper;
import com.sudaotech.huolijuzhen.provider.dao.LocationServiceParkEntityMapper;
import com.sudaotech.huolijuzhen.provider.dao.LocationServiceProjectEntityMapper;
import com.sudaotech.huolijuzhen.provider.dao.LocationTemplateLabelEntityMapper;
import com.sudaotech.huolijuzhen.provider.dao.OrderTemplateEntityMapper;
import com.sudaotech.huolijuzhen.provider.dao.ProviderEntityMapper;
import com.sudaotech.huolijuzhen.provider.dao.ServiceProScaneEntityMapper;
import com.sudaotech.huolijuzhen.provider.dao.ServiceProjectHistoryEntityMapper;
import com.sudaotech.huolijuzhen.provider.service.ApplyLabelService;
import com.sudaotech.huolijuzhen.provider.service.ApplyLabelServiceImpl;
import com.sudaotech.huolijuzhen.provider.service.ApplyOrderService;
import com.sudaotech.huolijuzhen.provider.service.ApplyOrderServiceImpl;
import com.sudaotech.huolijuzhen.provider.service.ApplyTemplateService;
import com.sudaotech.huolijuzhen.provider.service.ApplyTemplateServiceImpl;
import com.sudaotech.huolijuzhen.provider.service.OrderTemplateService;
import com.sudaotech.huolijuzhen.provider.service.OrderTemplateServiceImpl;
import com.sudaotech.huolijuzhen.provider.service.ProviderService;
import com.sudaotech.huolijuzhen.provider.service.ProviderServiceImpl;
import com.sudaotech.huolijuzhen.provider.service.ServiceCollectService;
import com.sudaotech.huolijuzhen.provider.service.ServiceCollectServiceImpl;
import com.sudaotech.huolijuzhen.provider.service.ServiceCommentService;
import com.sudaotech.huolijuzhen.provider.service.ServiceCommentServiceImpl;
import com.sudaotech.huolijuzhen.provider.service.ServiceParkService;
import com.sudaotech.huolijuzhen.provider.service.ServiceParkServiceImpl;
import com.sudaotech.huolijuzhen.provider.service.ServiceProScaneService;
import com.sudaotech.huolijuzhen.provider.service.ServiceProScaneServiceImpl;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectHistoryService;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectHistoryServiceImpl;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectServiceImpl;
import com.sudaotech.huolijuzhen.provider.service.TemplateLabelService;
import com.sudaotech.huolijuzhen.provider.service.TemplateLabelServiceImpl;
import com.sudaotech.huolijuzhen.provider.web.admin.enterprise.AdminEnterpriseApplyOrderResource;
import com.sudaotech.huolijuzhen.provider.web.admin.enterprise.AdminEnterpriseServiceCollectResource;
import com.sudaotech.huolijuzhen.provider.web.admin.enterprise.AdminEnterpriseServiceCommentResource;
import com.sudaotech.huolijuzhen.provider.web.admin.enterprise.AdminEnterpriseServiceProjectResource;
import com.sudaotech.huolijuzhen.provider.web.admin.park.AdminParkApplyOrderResource;
import com.sudaotech.huolijuzhen.provider.web.admin.park.AdminParkProviderResource;
import com.sudaotech.huolijuzhen.provider.web.admin.park.AdminParkServiceProjectResource;
import com.sudaotech.huolijuzhen.provider.web.admin.platform.AdminPlatformApplyOrderResource;
import com.sudaotech.huolijuzhen.provider.web.admin.platform.AdminPlatformApplyTemplateResource;
import com.sudaotech.huolijuzhen.provider.web.admin.platform.AdminPlatformOrderTemplateResource;
import com.sudaotech.huolijuzhen.provider.web.admin.platform.AdminPlatformProviderResource;
import com.sudaotech.huolijuzhen.provider.web.admin.platform.AdminPlatformServiceProScaneResource;
import com.sudaotech.huolijuzhen.provider.web.admin.platform.AdminPlatformServiceProjectResource;
import com.sudaotech.huolijuzhen.provider.web.admin.platform.AdminPlatformTemplateLabelResource;
import com.sudaotech.huolijuzhen.provider.web.admin.platform.ServiceProjectHistoryResource;
import com.sudaotech.huolijuzhen.provider.web.app.enterprise.AppEnterpriseApplyOrderResource;
import com.sudaotech.huolijuzhen.provider.web.app.enterprise.AppEnterpriseServiceCollectResource;
import com.sudaotech.huolijuzhen.provider.web.app.enterprise.AppEnterpriseServiceCommentResource;
import com.sudaotech.huolijuzhen.provider.web.app.enterprise.AppEnterpriseServiceProjectResource;
import com.sudaotech.huolijuzhen.provider.web.app.enterprise.AppEnterpriseServiceScenarioResource;
import com.sudaotech.huolijuzhen.provider.web.app.enterprise.AppEnterpriseServiceTypeResource;
import com.sudaotech.huolijuzhen.resources.dao.LocationResourceInfoEntityMapper;
import com.sudaotech.huolijuzhen.resources.service.ResInfoService;
import com.sudaotech.huolijuzhen.resources.service.ResInfoServiceImpl;
import com.sudaotech.huolijuzhen.resources.service.ResourceInfoService;
import com.sudaotech.huolijuzhen.resources.service.ResourceInfoServiceImpl;
import com.sudaotech.huolijuzhen.resources.service.UnitTierInfoService;
import com.sudaotech.huolijuzhen.resources.service.UnitTierInfoServiceImpl;
import com.sudaotech.huolijuzhen.resources.web.admin.park.ResInfoResource;
import com.sudaotech.huolijuzhen.resources.web.admin.park.ResourceInfoResource;
import com.sudaotech.huolijuzhen.resources.web.admin.park.UnitTierInfoResource;
import com.sudaotech.huolijuzhen.sys.common.dao.LocationImageInfoEntityMapper;
import com.sudaotech.huolijuzhen.sys.common.dao.LocationOperatorHistoryEntityMapper;
import com.sudaotech.huolijuzhen.sys.common.service.ImageInfoService;
import com.sudaotech.huolijuzhen.sys.common.service.ImageInfoServiceImpl;
import com.sudaotech.huolijuzhen.sys.common.service.OperatorHistoryService;
import com.sudaotech.huolijuzhen.sys.common.service.OperatorHistoryServiceImpl;
import com.sudaotech.huolijuzhen.sys.common.web.BaseServiceScenarioResource;
import com.sudaotech.huolijuzhen.sys.common.web.BaseServiceTypeResource;
import com.sudaotech.huolijuzhen.sys.common.web.DetailAnnouncementResource;
import com.sudaotech.huolijuzhen.sys.common.web.DetailCommunityResource;
import com.sudaotech.huolijuzhen.sys.common.web.DetailServiceProjectResource;
import com.sudaotech.huolijuzhen.sys.common.web.OperatorHistoryResource;
import com.sudaotech.huolijuzhen.sys.common.web.Statistics;
import com.sudaotech.huolijuzhen.task.dao.LocationDescribleEntityMapper;
import com.sudaotech.huolijuzhen.task.dao.LocationTaskEntityMapper;
import com.sudaotech.huolijuzhen.task.dao.LocationTaskExecutorEntityMapper;
import com.sudaotech.huolijuzhen.task.dao.TaskEntityMapper;
import com.sudaotech.huolijuzhen.task.service.DescribleService;
import com.sudaotech.huolijuzhen.task.service.DescribleServiceImpl;
import com.sudaotech.huolijuzhen.task.service.TaskExecutorService;
import com.sudaotech.huolijuzhen.task.service.TaskExecutorServiceImpl;
import com.sudaotech.huolijuzhen.task.service.TaskService;
import com.sudaotech.huolijuzhen.task.service.TaskServiceImpl;
import com.sudaotech.huolijuzhen.task.web.admin.enterprise.AdminEnterpriseTaskResource;
import com.sudaotech.huolijuzhen.task.web.admin.park.AdminParkTaskResource;
import com.sudaotech.huolijuzhen.task.web.admin.park.DescribleResource;
import com.sudaotech.huolijuzhen.task.web.app.enterprise.AppEnterpriseTaskResource;
import com.sudaotech.huolijuzhen.task.web.app.tenement.AppTenementTaskResource;
import com.sudaotech.huolijuzhen.task.web.app.tenement.AppTenmentDescribleResource;
import com.sudaotech.huolijuzhen.transaction.dao.TransactionRecordEntityMapper;
import com.sudaotech.huolijuzhen.transaction.service.TransactionRecordService;
import com.sudaotech.huolijuzhen.transaction.service.TransactionRecordServiceImpl;
import com.sudaotech.huolijuzhen.transaction.web.TransactionRecordResource;
import com.sudaotech.message.MsgBizType;
import com.sudaotech.message.MsgStatus;
import com.sudaotech.message.MsgType;
import com.sudaotech.message.SourceType;
import com.sudaotech.message.dao.MsgBizTypeHandler;
import com.sudaotech.message.dao.MsgStatusHandler;
import com.sudaotech.message.dao.MsgTypeHandler;
import com.sudaotech.message.dao.SourceTypeHandler;
import com.sudaotech.user.dao.handler.VersionHandler;
import com.sudaotech.user.enums.Version;

public class BusinessModule extends BaseModule {

    @Override
    protected void initialize() {
        super.initialize();
//        mqModule();
        typeModule();
//        elasticSearchModule();
        redisModule();
        bizModule();
    }

    private void mqModule() {
        //bind(MqService.class).to(MqServiceImpl.class).in(Scopes.SINGLETON);

		/*bind(ExceptionLogMqReceiver.class).in(Scopes.SINGLETON);
        bind(TimerTaskService.class).in(Scopes.SINGLETON);
		
		//Exception
		bind(ExceptionLogService.class).to(ExceptionLogServiceImpl.class).in(Scopes.SINGLETON);
		addMapperClass(ExceptionLogEntityMapper.class);*/
    }

    private void typeModule() {
        //枚举类型
        this.handleType(Version.class).with(VersionHandler.class);
        this.handleType(UseStatus.class).with(UseStatusHandler.class);
        this.handleType(ResType.class).with(ResTypeHandler.class);

        //消息
        this.handleType(MsgType.class).with(MsgTypeHandler.class);
        this.handleType(MsgStatus.class).with(MsgStatusHandler.class);
        this.handleType(MsgBizType.class).with(MsgBizTypeHandler.class);
        this.handleType(SourceType.class).with(SourceTypeHandler.class);

        //企业相关
        this.handleType(CorrType.class).with(CorrTypeHandler.class);
        this.handleType(CorrStatus.class).with(CorrStatusHandler.class);
        this.handleType(CreateSource.class).with(CreateSourceHandler.class);
        this.handleType(CellphoneParams.class).with(CellphomeParamsHandler.class);
        this.handleType(ContractStatus.class).with(ContractStatusHandler.class);

        //TODO 
        this.handleType(PublicGrade.class).with(PublicGradeHandler.class);
        this.handleType(CreateSide.class).with(CreateSideHandler.class);
        this.handleType(EnableStatus.class).with(EnableStatusHandler.class);
        this.handleType(ServerGrade.class).with(ServerGradeHandler.class);
        this.handleType(ApprovalStatus.class).with(ApprovalStatusHandler.class);
        this.handleType(Grade.class).with(GradeHandler.class);
        this.handleType(CommentGrade.class).with(CommentGradeHandler.class);
        this.handleType(CycleType.class).with(CycleTypeHandler.class);
        this.handleType(TaskStatus.class).with(TaskStatusHandler.class);
        this.handleType(TaskType.class).with(TaskTypeHandler.class);
        this.handleType(ChooseStatus.class).with(ChooseStatusHandler.class);
        this.handleType(ServiceGrade.class).with(serviceGradeHandler.class);
        this.handleType(ServiceApprovalStatus.class).with(ServiceApprovalStatusHandler.class);
        this.handleType(LabelType.class).with(LabelTypeHandler.class);
        this.handleType(FileType.class).with(FileTypeHandler.class);
        this.handleType(PayWay.class).with(PayWayHandler.class);
        this.handleType(ReqSourceType.class).with(ReqSourceTypeHandler.class);
        this.handleType(PlanStatus.class).with(PlanStatusHandler.class);
        this.handleType(SendGrade.class).with(SendGradeHandler.class);
        this.handleType(BusinessType.class).with(BusinessTypeHandler.class);
        this.handleType(OperatorType.class).with(OperatorTypeHandler.class);
        this.handleType(ImageType.class).with(ImageTypeHandler.class);

        //园区
        this.handleType(CalcDimension.class).with(CalcDimensionHandler.class);
		this.handleType(ApplyOrderStatus.class).with(ApplyOrderStatusHandler.class);
		this.handleType(ApplyOrderType.class).with(ApplyOrderTypeHandler.class);
		this.handleType(EnableAvg.class).with(EnableAvgHandler.class);

		//费用项目
		this.handleType(ChargeMode.class).with(ChargeModeHandler.class);
		this.handleType(ComputeMode.class).with(ComputeModeHandler.class);
		
		this.handleType(BillStatus.class).with(BillStatusHandler.class);
		this.handleType(BillSubmitStatus.class).with(BillSubmitStatusHandler.class);
		this.handleType(BillApprovalStatus.class).with(BillApprovalStatusHandler.class);
		this.handleType(BillPushStatus.class).with(BillPushStatusHandler.class);
		this.handleType(BillConfirmStatus.class).with(BillConfirmStatusHandler.class);
		this.handleType(BillVerificationStatus.class).with(BillVerificationStatusHandler.class);
		this.handleType(BillUrgePushStatus.class).with(BillUrgePushStatusHandler.class);
		this.handleType(BillOperType.class).with(BillOperTypeHandler.class);
		
        //交易记录
		this.handleType(PayChannels.class).with(PayChannelsHandler.class);
		this.handleType(TransactionType.class).with(TransactionTypeHandler.class);
		this.handleType(TransDirectionType.class).with(TransDirectionTypeHandler.class);
		this.handleType(TransferSourceType.class).with(TransferSourceTypeHandler.class);
		this.handleType(SuccessOrFailEnums.class).with(SuccessOrFailEnumsHandler.class);
		
		//企业入驻
		this.handleType(EntryType.class).with(EntryTypeHandler.class);
		this.handleType(TreatmentStatus.class).with(TreatmentStatusHandler.class);
		
		//审批流程（合同审批、账单审批、账单核销）
		this.handleType(ApprovalType.class).with(ApprovalTypeHandler.class);
		this.handleType(ApprovalProcessStatus.class).with(ApprovalProcessStatusHandler.class);
		
    }


    private void elasticSearchModule() {
        //bind(ElasticSearchService.class).to(ElasticSearchServiceImpl.class).in(Scopes.SINGLETON);
    }

    private void redisModule() {

    }

    private void bizModule() {

        /*******************系统公共模块管理********************/
    	//操作历史记录
    	bind(OperatorHistoryResource.class);
    	bind(OperatorHistoryService.class).to(OperatorHistoryServiceImpl.class).in(Scopes.SINGLETON);
    	addMapperClass(LocationOperatorHistoryEntityMapper.class);
    	//图片操作
    	bind(ImageInfoService.class).to(ImageInfoServiceImpl.class).in(Scopes.SINGLETON);
    	addMapperClass(LocationImageInfoEntityMapper.class);
    	//h5页面
    	bind(DetailAnnouncementResource.class);
    	bind(DetailServiceProjectResource.class);
    	bind(DetailCommunityResource.class);
        //服务类型
        bind(BaseServiceTypeResource.class);
        //服务场景
        bind(BaseServiceScenarioResource.class);
        //统计
        bind(Statistics.class);

    	/*******************基础数据管理********************/
        //行政位置
        bind(LocationResource.class);
        bind(AreaService.class).to(AreaServiceImpl.class).in(Scopes.SINGLETON);
        bind(LocationService.class).to(LocationServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(ServiceLocationEntityMapper.class);

        //服务类型
        bind(ServiceTypeResource.class);
        bind(ServiceTypeService.class).to(ServiceTypeServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(LocationServiceTypeEntityMapper.class);

        //服务场景
        bind(ServiceScenarioResource.class);
        bind(ServiceScenarioService.class).to(ServiceScenarioServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(LocationServiceScenarioEntityMapper.class);

        /*******************政策管理********************/
        //政策管理
        bind(AdminPlatformPolicyResource.class);
        bind(PolicyService.class).to(PolicyServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(LocationPolicyEntityMapper.class);
        
        //admin 企业
        bind(AdminEnterprisePolicyResource.class);
        
        /*******************公告管理********************/

        //公告管理
        //平台
        bind(AdminPlatformAnnouncementResource.class);
        addMapperClass(LocationParkInfoEntityMapper.class);
        bind(AnnouncementService.class).to(AnnouncementServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(AnnouncementEntityMapper.class);

        //园区
        bind(AdminParkAnnouncementResource.class);

        /*******************社群管理********************/

        //社群活动(web 平台)
        bind(AdminPlatformCommunityResource.class);
        bind(CommunityService.class).to(CommunityServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(LocationCommunityEntityMapper.class);

        //社群活动(web 园区)
        bind(AdminParkCommunityResource.class);

        //活动申请管理(web 平台)
        bind(AdminPlatformCommunityApplyResource.class);
        bind(CommunityApplyService.class).to(CommunityApplyServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(LocationCommunityApplyEntityMapper.class);

        ///admin 企业
        bind(AdminEnterpriseCommunityResource.class);
        bind(AdminEnterpriseCommunityApplyResource.class);
        
        /*******************设备管理********************/

        //设备类型
        bind(EquipmentTypeResource.class);
        bind(EquipmentTypeService.class).to(EquipmentTypeServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(LocationEquipmentTypeEntityMapper.class);

        //设备维护项目
        bind(EquipmentPreserveResource.class);
        bind(EquipmentPreserveService.class).to(EquipmentPreserveServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(LocationEquipmentPreserveEntityMapper.class);

        bind(EquipmentPlanService.class).to(EquipmentPlanServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(EquipmentPlanEntityMapper.class);

        bind(TaskService.class).to(TaskServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(LocationTaskEntityMapper.class);

        //维护计划
        bind(EquipmentPlanResource.class);
        bind(EquipmentPlanService.class).to(EquipmentPlanServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(LocationEquipmentPlanEntityMapper.class);

        /*******************任务管理********************/

        //任务管理
        bind(AdminParkTaskResource.class);
        bind(TaskExecutorService.class).to(TaskExecutorServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(LocationTaskExecutorEntityMapper.class);
        bind(TaskService.class).to(TaskServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(TaskEntityMapper.class);

        //常用术语管理
        bind(DescribleResource.class);
        bind(DescribleService.class).to(DescribleServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(LocationDescribleEntityMapper.class);

        /*******************服务管理********************/
        //服务商管理
        bind(AdminPlatformProviderResource.class);
        bind(ProviderService.class).to(ProviderServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(ProviderEntityMapper.class);

        //模板标签
        bind(AdminPlatformTemplateLabelResource.class);
        bind(TemplateLabelService.class).to(TemplateLabelServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(LocationTemplateLabelEntityMapper.class);

        //申请单模板
        bind(AdminPlatformApplyTemplateResource.class);
        bind(ApplyTemplateService.class).to(ApplyTemplateServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(ApplyTemplateEntityMapper.class);

        //订单模板
        bind(AdminPlatformOrderTemplateResource.class);
        bind(OrderTemplateService.class).to(OrderTemplateServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(OrderTemplateEntityMapper.class);


        //服务项目管理
        bind(ServiceParkService.class).to(ServiceParkServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(LocationServiceParkEntityMapper.class);
        bind(AdminPlatformServiceProjectResource.class);
        bind(ServiceProjectService.class).to(ServiceProjectServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(LocationServiceProjectEntityMapper.class);
        
        //服务项目历史表
        addMapperClass(ServiceProjectHistoryEntityMapper.class);
        bind(ServiceProjectHistoryService.class).to(ServiceProjectHistoryServiceImpl.class).in(Scopes.SINGLETON);
        bind(ServiceProjectHistoryResource.class);

        //服务项目 服务场景关联关系
        bind(AdminPlatformServiceProScaneResource.class);
        bind(ServiceProScaneService.class).to(ServiceProScaneServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(ServiceProScaneEntityMapper.class);
        
        //服务商管理
        bind(AdminParkProviderResource.class);
        //服务项目管理
        bind(AdminParkServiceProjectResource.class);

        //平台 服务订单  服务申请单
        bind(AdminPlatformApplyOrderResource.class);
        bind(ApplyOrderService.class).to(ApplyOrderServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(LocationApplyOrderEntityMapper.class);

        //园区 服务订单 服务申请单
        bind(AdminParkApplyOrderResource.class);
        
        ///app enterprise
        //企业 app 服务项目
        bind(AppEnterpriseServiceProjectResource.class);
        //企业 app 服务项目订单、申请单
        bind(AppEnterpriseApplyOrderResource.class);
        //企业 app 服务类型
        bind(AppEnterpriseServiceTypeResource.class);
        //企业 app  服务场景
        bind(AppEnterpriseServiceScenarioResource.class);
        //企业 app 服务项目收藏
        bind(AppEnterpriseServiceCollectResource.class);
        bind(ServiceCollectService.class).to(ServiceCollectServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(LocationServiceCollectEntityMapper.class);
        //企业 app 服务项目评论
        bind(AppEnterpriseServiceCommentResource.class);
        bind(ServiceCommentService.class).to(ServiceCommentServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(LocationServiceCommentEntityMapper.class);
        ///admin enterprise
        //服务项目
        bind(AdminEnterpriseServiceProjectResource.class);
        //服务项目申请单订单
        bind(AdminEnterpriseApplyOrderResource.class);
        //服务项目收藏
        bind(AdminEnterpriseServiceCollectResource.class);
        //服务项目评论
        bind(AdminEnterpriseServiceCommentResource.class);
        
        //我的订单详情
        addMapperClass(ApplyLabelEntityMapper.class);
        bind(ApplyLabelService.class).to(ApplyLabelServiceImpl.class).in(Scopes.SINGLETON);
        
        ///支付
    	bind(PaymentService.class).to(PaymentServiceImpl.class).in(Scopes.SINGLETON);
    	bind(PaymentResource.class);
    	
        ///交易流水
    	addMapperClass(TransactionRecordEntityMapper.class);
    	bind(TransactionRecordService.class).to(TransactionRecordServiceImpl.class).in(Scopes.SINGLETON);
    	bind(TransactionRecordResource.class);
    	
    	
        /********************园区管理********************/

        //园区
        bind(ParkInfoResource.class);
        bind(ParkInfoService.class).to(ParkInfoServiceImpl.class).in(Scopes.SINGLETON);
//        addMapperClass(LocationParkInfoEntityMapper.class);

        //园区资源管理
        addMapperClass(ResInfoEntityMapper.class);
        addMapperClass(LocationResourceInfoEntityMapper.class);
        addMapperClass(UnitTierInfoEntityMapper.class);
        bind(ResInfoService.class).to(ResInfoServiceImpl.class).in(Scopes.SINGLETON);
        bind(ResourceInfoService.class).to(ResourceInfoServiceImpl.class).in(Scopes.SINGLETON);
        bind(UnitTierInfoService.class).to(UnitTierInfoServiceImpl.class).in(Scopes.SINGLETON);
        bind(ResInfoResource.class);
        bind(ResourceInfoResource.class);
        bind(UnitTierInfoResource.class);

        //园区组管理
        addMapperClass(ParkGroupInfoEntityMapper.class);
        addMapperClass(ParkGroupParkInfoMapper.class);
        addMapperClass(ParkGroupUserMapper.class);
        bind(ParkGroupInfoService.class).to(ParkGroupInfoServiceImpl.class).in(Scopes.SINGLETON);
        bind(ParkGroupParkInfoService.class).to(ParkGroupParkInfoServiceImpl.class).in(Scopes.SINGLETON);
        bind(ParkGroupUserInfoService.class).to(ParkGroupUserInfoServiceImpl.class).in(Scopes.SINGLETON);
        bind(ParkGroupUserInfoResource.class);
        bind(ParkGroupInfoResource.class);
        bind(ParkGroupParkInfoResource.class);

        /********************消息管理********************/

        //消息相关
        addMapperClass(MessageEntityMapper.class);

        bind(MessageService.class).to(MessageServiceImpl.class).in(Scopes.SINGLETON);
        bind(com.sudaotech.huolijuzhen.basic.web.app.enterprise.MessageResource.class);
        bind(com.sudaotech.huolijuzhen.basic.web.app.park.MessageResource.class);
        bind(com.sudaotech.huolijuzhen.basic.web.admin.enterprise.MessageResource.class);

        /********************企业管理********************/

        ////企业主信息
        addMapperClass(LocationEnterpriseInfoEntityMapper.class);
        bind(EnterpriseInfoService.class).to(EnterpriseInfoServiceImpl.class).in(Scopes.SINGLETON);
        ///admin
        //园区
        bind(EnterpriseInfoResource.class);
        //平台
        bind(com.sudaotech.huolijuzhen.enterprise.web.admin.platform.EnterpriseInfoResource.class);
        //官网首页
        bind(com.sudaotech.huolijuzhen.enterprise.web.admin.main.EnterpriseInfoResource.class);

        //企业档案
        addMapperClass(EnterpriseDossierEntityMapper.class);
        bind(EnterpriseDossierService.class).to(EnterpriseDossierServiceImpl.class).in(Scopes.SINGLETON);
        bind(EnterpriseDossierResource.class);

        //企业关联园区关系
        addMapperClass(EnterpriseCottMapper.class);
        bind(EnterpriseCottService.class).to(EnterpriseCottServiceImpl.class).in(Scopes.SINGLETON);
        //admin
        bind(EnterpriseCottResource.class);
        bind(com.sudaotech.huolijuzhen.enterprise.web.admin.platform.EnterpriseCottResource.class);
        bind(com.sudaotech.huolijuzhen.enterprise.web.admin.enterprise.EnterpriseCottResource.class);
        
        //app
        bind(com.sudaotech.huolijuzhen.enterprise.web.app.enterprise.EnterpriseCottResource.class);
        

        //合同信息
        addMapperClass(LocationContractInfoEntityMapper.class);
        bind(ContractInfoService.class).to(ContractInfoServiceImpl.class).in(Scopes.SINGLETON);
        bind(ContractInfoResource.class);

        //合同档案
        addMapperClass(ContractDossierEntityMapper.class);
        bind(ContractDossierService.class).to(ContractDossierServiceImpl.class).in(Scopes.SINGLETON);

        //合同关联
        addMapperClass(EnterpriseCorrContractEntityMapper.class);
        bind(EnterpriseCorrContractService.class).to(EnterpriseCorrContractServiceImpl.class).in(Scopes.SINGLETON);
        bind(EnterpriseCorrContractResource.class);
        
        //合同关联资源
        addMapperClass(ContractResourceEntityMapper.class);
        bind(ContractResourceService.class).to(ContractResourceServiceImpl.class).in(Scopes.SINGLETON);
        bind(ContractResourceResource.class);

        //业务关联
        addMapperClass(EnterpriseCorrBusinessEntityMapper.class);
        bind(EnterpriseCorrBusinessService.class).to(EnterpriseCorrBusinessServiceImpl.class).in(Scopes.SINGLETON);
        bind(EnterpriseCorrBusinessResource.class);
        
        //合同月份账单
        addMapperClass(ContractBillEntityMapper.class);
        bind(ContractBillService.class).to(ContractBillServiceImpl.class).in(Scopes.SINGLETON);
        bind(ContractBillResource.class);

        /*********************社群管理*********************/

        //活动申请管理（web 园区）
        bind(AdminParkCommunityApplyResource.class);
        bind(CommunityApplyService.class).to(CommunityApplyServiceImpl.class).in(Scopes.SINGLETON);

        //社群活动（app 企业）
        bind(AppEnterpriseCommunityResource.class);
        bind(CommunityService.class).to(CommunityServiceImpl.class).in(Scopes.SINGLETON);

        //活动申请查询（app 企业）
        bind(AppEnterpriseCommunityApplyResource.class);
        bind(CommunityApplyService.class).to(CommunityApplyServiceImpl.class).in(Scopes.SINGLETON);

        /********************维修申报理********************/

        //企业维修申报
        bind(AppTenmentDescribleResource.class);
        bind(AppTenementEquipmentTypeResource.class);
        bind(AppEnterpriseTaskResource.class);

        //园区物业管理
        bind(AppTenementTaskResource.class);
        
        //审批流程添加（合同审批、账单审批、账单核销）
        bind(AdminParkApprovalTypeResource.class);
        bind(AppParkApprovalTypeResource.class);
        bind(ApprovalTypeService.class).to(ApprovalTypeServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(ApprovalTypeEntityMapper.class);

        bind(AdminParkApprovalTypeItemResource.class);
        bind(AppParkApprovalTypeItemResource.class);
        bind(ApprovalTypeItemService.class).to(ApprovalTypeItemServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(ApprovalTypeItemEntityMapper.class);
        
        bind(AdminParkApprovalRecordResource.class);
        bind(AppParkApprovalRecordResource.class);
        bind(ApprovalRecordService.class).to(ApprovalRecordServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(ApprovalRecordEntityMapper.class);
        
        bind(AdminParkApprovalProcessResource.class);
        bind(AppParkApprovalProcessResource.class);
        bind(ApprovalProcessService.class).to(ApprovalProcessServiceImpl.class).in(Scopes.SINGLETON);
        addMapperClass(ApprovalProcessEntityMapper.class);
        
        //admin 企业
        bind(AdminEnterpriseTaskResource.class);

        /*********************横幅资源********************/
        addMapperClass(BannerSourcesEntityMapper.class);
        bind(BannerSourcesService.class).to(BannerSourcesServiceImpl.class).in(Scopes.SINGLETON);
        //园区APP
        bind(com.sudaotech.huolijuzhen.basic.web.app.park.BannerSourcesResource.class);
        //企业APP
        bind(com.sudaotech.huolijuzhen.basic.web.app.enterprise.BannerSourcesResource.class);
        //企业PC
        bind(com.sudaotech.huolijuzhen.basic.web.admin.enterprise.BannerSourcesResource.class);

        /********************企业风采**********************/
        addMapperClass(EnterpriseDisplayEntityExtendsMapper.class);
        bind(EnterpriseDisplayService.class).to(EnterpriseDisplayServiceImpl.class).in(Scopes.SINGLETON);
        //企业
        bind(com.sudaotech.huolijuzhen.community.web.admin.enterprise.EnterpriseDisplayResource.class);
        //园区
        bind(com.sudaotech.huolijuzhen.community.web.admin.park.EnterpriseDisplayResource.class);
        //企业内部服务
        bind(BannerSourcesInnerServiceResource.class);
        //平台
        bind(com.sudaotech.huolijuzhen.community.web.admin.platform.EnterpriseDisplayResource.class);
        
        /******************code生成器*********************/
        //code生成器
        addMapperClass(GenCodeMapper.class);
        bind(GenCodeService.class).to(GenCodeServiceImpl.class).in(Scopes.SINGLETON);
        
        /*******************费用账单**********************/
        ////费用项目
        addMapperClass(CostProEntityMapper.class);
        bind(CostProService.class).to(CostProServiceImpl.class).in(Scopes.SINGLETON);
        //平台基础数据
        bind(CostProResource.class);
        //园区账单
        bind(com.sudaotech.huolijuzhen.bill.web.admin.park.CostProResource.class);

        //费用项目计算方式
        addMapperClass(BillCostCalRulesEntityMapper.class);
        bind(BillCostCalRulesService.class).to(BillCostCalRulesServiceImpl.class).in(Scopes.SINGLETON);
        //费用项目计算规则滚动
        addMapperClass(RollPeriodEntityMapper.class);
        bind(RollPeriodService.class).to(RollPeriodServiceImpl.class).in(Scopes.SINGLETON);
        bind(RollPeriodResource.class);
        
        //园区
        bind(BillCostCalRulesResource.class);
        
        //费用调整方式
        addMapperClass(BillCcrAdjEntityMapper.class);
        bind(BillCcrAdjService.class).to(BillCcrAdjServiceImpl.class).in(Scopes.SINGLETON);
        bind(BillCcrAdjResource.class);

        ////账单费用明细
        addMapperClass(BillCostDetailMapper.class);
        bind(BillCostDetailService.class).to(BillCostDetailServiceImpl.class).in(Scopes.SINGLETON);
        bind(BillCostDetailResource.class);

        //费用项目用量表
        addMapperClass(CostProSettingEntityMapper.class);
        bind(CostProSettingService.class).to(CostProSettingServiceImpl.class).in(Scopes.SINGLETON);
        bind(CostProSettingResource.class);
        
        ////账单
        addMapperClass(BillInfoMapper.class);
        bind(BillInfoService.class).to(BillInfoServiceImpl.class).in(Scopes.SINGLETON);
        //admin园区
        bind(BillInfoResource.class);
        //admin企业
        bind(com.sudaotech.huolijuzhen.bill.web.admin.enterprise.BillInfoResource.class);
        //app企业
        bind(com.sudaotech.huolijuzhen.bill.web.app.enterprise.BillInfoResource.class);
        
        
        ////账单变更记录
        addMapperClass(BillChangeLogsEntityMapper.class);
        bind(BillChangeLogsService.class).to(BillChangeLogsServiceImpl.class).in(Scopes.SINGLETON);
        //园区
        bind(BillChangeLogsResource.class);
        
        ///账单支付凭证
        addMapperClass(BillPayVoucherEntityMapper.class);
        bind(BillPayVoucherService.class).to(BillPayVoucherServiceImpl.class).in(Scopes.SINGLETON);

        ///账单收款记录
        addMapperClass(BillCollectionRecordMapper.class);
        bind(BillCollectionRecordService.class).to(BillCollectionRecordServiceImpl.class).in(Scopes.SINGLETON);
        bind(BillCollectionRecordResource.class);
        
        /********************系统配置********************/
        //系统配置
        addMapperClass(SystemConfigEntityExtendsMapper.class);
        bind(SystemConfigService.class).to(SystemConfigServiceImpl.class).in(Scopes.SINGLETON);
        bind(SystemConfigResource.class);
        
        //企业用户变更手机号
        bind(AdminCellphoneResource.class);
        
       /*****************企业用户与园区关联关系******************/
        addMapperClass(EnterpriseUserCottEntityMapper.class);
        bind(EnterpriseUserCottService.class).to(EnterpriseUserCottServiceImpl.class).in(Scopes.SINGLETON);
        bind(EnterpriseUserCottResource.class);
        
		//-------环信通知
		//企业端app
		bind(NoticeEnterpriseService.class).to(NoticeEnterpriseServiceImpl.class).in(Scopes.SINGLETON);
		//园区端
		bind(NoticeParkService.class).to(NoticeParkServiceImpl.class).in(Scopes.SINGLETON);
		//测试用
		bind(AssemblyMessageResouce.class);
		
		/*******************入驻信息*******************/
		addMapperClass(EnterInfoEntityMapper.class);
		bind(EnterInfoService.class).to(EnterInfoServiceImpl.class).in(Scopes.SINGLETON);
		bind(com.sudaotech.huolijuzhen.enter.web.park.EnterInfoResource.class);
		bind(com.sudaotech.huolijuzhen.enter.web.provider.EnterInfoResource.class);
		bind(com.sudaotech.huolijuzhen.enter.web.all.EnterInfoResource.class);
		
    }
}