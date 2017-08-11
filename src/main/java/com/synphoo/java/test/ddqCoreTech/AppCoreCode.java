/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.ddqCoreTech;
public class AppCoreCode{
/*
	【首页同步订单数据分期数据API】
	=================================
	vbs.daihou.address=http://10.138.60.114:8091/BeanLoan
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	private static final Logger logger = LoggerFactory.getLogger(SltAccountManager.class);
	{
		Map<String, Object> requestMap = new HashMap<String, Object>();
		requestMap.put("BusinessIdList", vbsBids);
		String queryLoanDetailsAddress = vbsAddress + "/Loan/MainPageInfo/GET";
		String json = GsonUtils.toJson(requestMap);//封装的GsonUtils
		logger.info("首页查询接口，请求地址 {}，请求参数：{}", queryLoanDetailsAddress, json);
		StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
		//发post请求
		String respJson = HttpClientUtils.getMethodPostResponse(queryLoanDetailsAddress,entity);//封装的HttpClientUtils
		logger.info("queryLoanDetails->Response->" + respJson);
		Gson gson = new GsonBuilder().create();//google.gson
		List<VbsHomeSltDto> vbsResult = gson.fromJson(respJson, new TypeToken<List<VbsHomeSltDto>>() {}.getType());
		return DefaultResult.success(vbsResult);
	}
	=================================
	{
		DouDouQianService service = new DouDouQianService(new URL(address));
		DouDouQianServiceSoap vcreditSoap = service.getDouDouQianServiceSoap();
		RequestResult result = vcreditSoap.queryLoanDetails(json);//soap调queryLoanDetails方法
		logger.info("首页查询接口 :{}，返回的数据-->{}", "queryLoanDetails", GsonUtils.toJson(result));
		if (result.getStatus() == 0) {
			return DefaultResult.fail("调用首页查询接口api失败 " + result.getContent());
		}
		if (result.getResult() == null) {
			return DefaultResult.fail("数据异常");
		}
		Gson gson = new GsonBuilder().create();
		List<VbsHomeSltDto> vbsResult = gson.fromJson(result.getResult().toString(),new TypeToken<List<VbsHomeSltDto>>() {}.getType());
		if (Argument.isEmpty(vbsResult)) {
			return DefaultResult.fail("没有相应数据返回");
		}
	}
	=================================
	{
		DouDouQianService service = new DouDouQianService(new URL(address));
		DouDouQianServiceSoap vcreditSoap = service.getDouDouQianServiceSoap();
		RequestResult requestResult = vcreditSoap.queryAdvCloanInfo(json);
		logger.info("清贷查询请求vbs接口 :{}，返回的数据-->{}", "queryAdvCloanInfo", GsonUtils.toJson(requestResult));

		respDto.setStatus(String.valueOf(requestResult.getStatus()));
		if ("1".equals(respDto.getStatus())) {
			//返回成功了后这里的content需要转换成advance
			respDto.setContent(requestResult.getResult().toString());
			advanceClearLoanDtos = GsonUtils.convertList(respDto.getContent(),AdvanceClearLoanDto.class);
			respDto.setAdvanceClearLoan(advanceClearLoanDtos);
		} else if ("0".equals(respDto.getStatus())) {
			respDto.setContent(requestResult.getContent().toString());
		} else {
			respDto.setException(requestResult.getContent().toString());
		}
	}
	=================================
		CommonVBSResponseDto resultDto = new CommonVBSResponseDto();
	    	// TODO
	        try {
			logger.info("调用VBS接口更换银行卡的信息接口 repaceBidCardInfoTransfer-->address-->" + address);
			String json = GsonUtils.toJson(requestDto);
			logger.info("调用VBS接口更换银行卡的信息接口-> repaceBidCardInfoTransfer ->json---->" + json);
			DouDouQianService service = new DouDouQianService(new URL(address));
			DouDouQianServiceSoap vcreditSoap = service.getDouDouQianServiceSoap();
			RequestResult responseResult = vcreditSoap.changeCard(json);
			logger.info("调用VBS接口更换银行卡的信息接口返回结果-> responseResult-->" + "responseResult.getStatus()=="
				    + responseResult.getStatus() + "responseResult.getContent()==" + responseResult.getContent());
			resultDto.setStatus(String.valueOf(responseResult.getStatus()));
			if ("1".equals(resultDto.getStatus())) {
			    resultDto.setResult(String.valueOf(responseResult.getContent()));
			}else {
				  //调用接口失败
			    resultDto.setContent(String.valueOf(responseResult.getContent())); 
			    resultDto.setResult(String.valueOf(responseResult.getContent()));
			    
			}
	        } catch (Exception e) {
	                e.printStackTrace();
	                logger.error("改卡，修改VBS合同失败======", e);
	        } 
	        
	        return resultDto;
	=================================
	
*/	
}