/**
 * Created by Venkatesh Kadimisetty
 * Date: 7/14/2016.
 */
app.factory('utilFactory', ['$q', '$http', function ($q, $http) {
	'use strict';
	var utilFactory = {};
	
	utilFactory.getParsedDate=function(date){
		return new Date(Date.parse(date));
	}
	
	utilFactory.getDifferenceDays=function(date1,date2){
		return Math.ceil((date1-date2)/(60*60*24*1000));
	}
	
	utilFactory.getConvertedDate=function(date){
		var year=date.getFullYear();
		var mnth=date.getMonth()+1;
		var date=date.getDate();
		return year+'-'+mnth+'-'+date;
	}
	
	return utilFactory;
}]);