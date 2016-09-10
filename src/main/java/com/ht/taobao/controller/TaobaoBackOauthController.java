//package com.ht.taobao.controller;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.validation.Validator;
//
//import org.apache.log4j.Logger;
//import org.jeecgframework.core.common.controller.BaseController;
//import org.jeecgframework.core.common.exception.BusinessException;
//import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
//import org.jeecgframework.core.common.model.json.AjaxJson;
//import org.jeecgframework.core.common.model.json.DataGrid;
//import org.jeecgframework.core.constant.Globals;
//import org.jeecgframework.core.util.ExceptionUtil;
//import org.jeecgframework.core.util.MyBeanUtils;
//import org.jeecgframework.core.util.ResourceUtil;
//import org.jeecgframework.core.util.StringUtil;
//import org.jeecgframework.poi.excel.ExcelImportUtil;
//import org.jeecgframework.poi.excel.entity.ExportParams;
//import org.jeecgframework.poi.excel.entity.ImportParams;
//import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
//import org.jeecgframework.tag.core.easyui.TagUtil;
//import org.jeecgframework.web.system.service.SystemService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.ht.taobao.entity.TaoBaoOAuth;
//import com.ht.taobao.service.TaobaoOauthServiceI;
//
///**   
// * @Title: Controller
// * @Description: 淘宝API
// * @author onlineGenerator
// * @date 2016-08-02 16:48:23
// * @version V1.0   
// *
// */
//@Scope("prototype")
//@Controller
//@RequestMapping("/taobaoOauthController")
//public class TaobaoBackOauthController extends BaseController {
//	/**
//	 * Logger for this class
//	 */
//	private static final Logger logger = Logger.getLogger(TaobaoBackOauthController.class);
//
//	@Autowired
//	private TaobaoOauthServiceI taobaoOauthService;
//	@Autowired
//	private SystemService systemService;
//	@Autowired
//	private Validator validator;
//	
//	private String message;
//	
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
//
//
//	/**
//	 * 淘宝API列表 页面跳转
//	 * 
//	 * @return
//	 */
//	@RequestMapping(params = "list")
//	public ModelAndView list(HttpServletRequest request) {
//		return new ModelAndView("com/ht/taobao/taobaoOauthList");
//	}
//
//	/**
//	 * easyui AJAX请求数据
//	 * 
//	 * @param request
//	 * @param response
//	 * @param dataGrid
//	 * @param user
//	 */
//
//	@RequestMapping(params = "datagrid")
//	public void datagrid(TaoBaoOAuth taobaoOauth,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
//		CriteriaQuery cq = new CriteriaQuery(TaoBaoOAuth.class, dataGrid);
//		//查询条件组装器
//		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, taobaoOauth, request.getParameterMap());
//		try{
//		//自定义追加查询条件
//		}catch (Exception e) {
//			throw new BusinessException(e.getMessage());
//		}
//		cq.add();
//		this.taobaoOauthService.getDataGridReturn(cq, true);
//		TagUtil.datagrid(response, dataGrid);
//	}
//
//	/**
//	 * 删除淘宝API
//	 * 
//	 * @return
//	 */
//	@RequestMapping(params = "doDel")
//	@ResponseBody
//	public AjaxJson doDel(TaoBaoOAuth taobaoOauth, HttpServletRequest request) {
//		AjaxJson j = new AjaxJson();
//		taobaoOauth = systemService.getEntity(TaoBaoOAuth.class, taobaoOauth.getId());
//		message = "淘宝API删除成功";
//		try{
//			taobaoOauthService.delete(taobaoOauth);
//			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
//		}catch(Exception e){
//			e.printStackTrace();
//			message = "淘宝API删除失败";
//			throw new BusinessException(e.getMessage());
//		}
//		j.setMsg(message);
//		return j;
//	}
//	
//	/**
//	 * 批量删除淘宝API
//	 * 
//	 * @return
//	 */
//	 @RequestMapping(params = "doBatchDel")
//	@ResponseBody
//	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
//		AjaxJson j = new AjaxJson();
//		message = "淘宝API删除成功";
//		try{
//			for(String id:ids.split(",")){
//				TaoBaoOAuth taobaoOauth = systemService.getEntity(TaoBaoOAuth.class, 
//				Integer.parseInt(id)
//				);
//				taobaoOauthService.delete(taobaoOauth);
//				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			message = "淘宝API删除失败";
//			throw new BusinessException(e.getMessage());
//		}
//		j.setMsg(message);
//		return j;
//	}
//
//
//	/**
//	 * 添加淘宝API
//	 * 
//	 * @param ids
//	 * @return
//	 */
//	@RequestMapping(params = "doAdd")
//	@ResponseBody
//	public AjaxJson doAdd(TaoBaoOAuth taobaoOauth, HttpServletRequest request) {
//		AjaxJson j = new AjaxJson();
//		message = "淘宝API添加成功";
//		try{
//			taobaoOauthService.save(taobaoOauth);
//			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
//		}catch(Exception e){
//			e.printStackTrace();
//			message = "淘宝API添加失败";
//			throw new BusinessException(e.getMessage());
//		}
//		j.setMsg(message);
//		return j;
//	}
//	
//	/**
//	 * 更新淘宝API
//	 * 
//	 * @param ids
//	 * @return
//	 */
//	@RequestMapping(params = "doUpdate")
//	@ResponseBody
//	public AjaxJson doUpdate(TaoBaoOAuth taobaoOauth, HttpServletRequest request) {
//		AjaxJson j = new AjaxJson();
//		message = "淘宝API更新成功";
//		TaoBaoOAuth t = taobaoOauthService.get(TaoBaoOAuth.class, taobaoOauth.getId());
//		try {
//			MyBeanUtils.copyBeanNotNull2Bean(taobaoOauth, t);
//			taobaoOauthService.saveOrUpdate(t);
//			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
//		} catch (Exception e) {
//			e.printStackTrace();
//			message = "淘宝API更新失败";
//			throw new BusinessException(e.getMessage());
//		}
//		j.setMsg(message);
//		return j;
//	}
//	
//
//	/**
//	 * 淘宝API新增页面跳转
//	 * 
//	 * @return
//	 */
//	@RequestMapping(params = "goAdd")
//	public ModelAndView goAdd(TaoBaoOAuth taobaoOauth, HttpServletRequest req) {
//		if (StringUtil.isNotEmpty(taobaoOauth.getId())) {
//			taobaoOauth = taobaoOauthService.getEntity(TaoBaoOAuth.class, taobaoOauth.getId());
//			req.setAttribute("taobaoOauthPage", taobaoOauth);
//		}
//		return new ModelAndView("com/ht/taobao/taobaoOauth-add");
//	}
//	/**
//	 * 淘宝API编辑页面跳转
//	 * 
//	 * @return
//	 */
//	@RequestMapping(params = "goUpdate")
//	public ModelAndView goUpdate(TaoBaoOAuth taobaoOauth, HttpServletRequest req) {
//		if (StringUtil.isNotEmpty(taobaoOauth.getId())) {
//			taobaoOauth = taobaoOauthService.getEntity(TaoBaoOAuth.class, taobaoOauth.getId());
//			req.setAttribute("taobaoOauthPage", taobaoOauth);
//		}
//		return new ModelAndView("com/ht/taobao/taobaoOauth-update");
//	}
//	
//	/**
//	 * 导入功能跳转
//	 * 
//	 * @return
//	 */
//	@RequestMapping(params = "upload")
//	public ModelAndView upload(HttpServletRequest req) {
//		req.setAttribute("controller_name","taobaoOauthController");
//		return new ModelAndView("common/upload/pub_excel_upload");
//	}
//	
//	/**
//	 * 导出excel
//	 * 
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping(params = "exportXls")
//	public String exportXls(TaoBaoOAuth taobaoOauth,HttpServletRequest request,HttpServletResponse response
//			, DataGrid dataGrid,ModelMap modelMap) {
//		CriteriaQuery cq = new CriteriaQuery(TaoBaoOAuth.class, dataGrid);
//		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, taobaoOauth, request.getParameterMap());
//		List<TaoBaoOAuth> taobaoOauths = this.taobaoOauthService.getListByCriteriaQuery(cq,false);
//		modelMap.put(NormalExcelConstants.FILE_NAME,"淘宝API");
//		modelMap.put(NormalExcelConstants.CLASS,TaoBaoOAuth.class);
//		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("淘宝API列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
//			"导出信息"));
//		modelMap.put(NormalExcelConstants.DATA_LIST,taobaoOauths);
//		return NormalExcelConstants.JEECG_EXCEL_VIEW;
//	}
//	/**
//	 * 导出excel 使模板
//	 * 
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping(params = "exportXlsByT")
//	public String exportXlsByT(TaoBaoOAuth taobaoOauth,HttpServletRequest request,HttpServletResponse response
//			, DataGrid dataGrid,ModelMap modelMap) {
//    	modelMap.put(NormalExcelConstants.FILE_NAME,"淘宝API");
//    	modelMap.put(NormalExcelConstants.CLASS,TaoBaoOAuth.class);
//    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("淘宝API列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
//    	"导出信息"));
//    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
//    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
//	}
//	
//	@SuppressWarnings("unchecked")
//	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
//	@ResponseBody
//	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
//		AjaxJson j = new AjaxJson();
//		
//		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
//		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
//			MultipartFile file = entity.getValue();// 获取上传文件对象
//			ImportParams params = new ImportParams();
//			params.setTitleRows(2);
//			params.setHeadRows(1);
//			params.setNeedSave(true);
//			try {
//				List<TaoBaoOAuth> listTaoBaoOAuths = ExcelImportUtil.importExcel(file.getInputStream(),TaoBaoOAuth.class,params);
//				for (TaoBaoOAuth taobaoOauth : listTaoBaoOAuths) {
//					taobaoOauthService.save(taobaoOauth);
//				}
//				j.setMsg("文件导入成功！");
//			} catch (Exception e) {
//				j.setMsg("文件导入失败！");
//				logger.error(ExceptionUtil.getExceptionMessage(e));
//			}finally{
//				try {
//					file.getInputStream().close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return j;
//	}
//	
//
//}
