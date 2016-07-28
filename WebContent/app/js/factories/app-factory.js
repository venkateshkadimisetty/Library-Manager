/**
 * Created by Venkatesh Kadimisetty
 * Date: 7/5/2016.		
 */
app.factory('appFactory', ['$q', '$http', function ($q, $http) {
	'use strict';
	var appFactory = {};
	
	appFactory.issueBook = function () {
		var deferredObject = $q.defer(),details;
		/*details = $http.get('demo');*/
		details =$http.get('demo?bookId=1');
		$q.all(details).then(function (data) {
			deferredObject.resolve(details);
		}, function (error) {
			deferredObject.reject({
				errorStatus: error.status
			});
		});
		return deferredObject.promise;
	};


	appFactory.getBookDetails = function (bookId) {
		var bookDetails;
		var deferredObject = $q.defer(),bookDetails;
		bookDetails = $http.get('demo?bookId='+bookId);
		$q.all(bookDetails).then(function (data) {
			deferredObject.resolve(bookDetails);
		}, function (error) {
			deferredObject.reject({
				errorStatus: error.status
			});
		});
		return deferredObject.promise;
	};
	
	appFactory.getMemberDetails = function (memId) {
		//var memberDetails;
		var deferredObject = $q.defer(),memberDetails;
		memberDetails = $http.get('memd?memId='+memId);
		$q.all(memberDetails).then(function (data) {
			deferredObject.resolve(memberDetails);
		}, function (error) {
			deferredObject.reject({
				errorStatus: error.status
			});
		});
		return deferredObject.promise;
	};
	
	appFactory.getDetails=function(bookId){
		var deferredObject = $q.defer(),lendDetails;
		lendDetails=$http.get('retb?bookId='+bookId);
		$q.all(lendDetails).then(function (data) {
			deferredObject.resolve(lendDetails);
		}, function (error) {
			deferredObject.reject({
				errorStatus: error.status
			});
		});
		return deferredObject.promise;
	};
	return appFactory;
}]);