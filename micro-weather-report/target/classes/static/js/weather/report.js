/**
 * report 页面下拉框时间
 * 2019年9月15日 23:50:21
 */
$(function(){
	$("#selectCityId").change(function(){
		var cityId = $("#selectCityId").val();
		var url = '/report/cityId/'+cityId
		window.location.href=url;
	})
});