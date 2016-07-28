/**
 * Created by Venkatesh Kadimisetty
 * Date: 7/5/2016.
 */
app.controller('issueBookController',function($scope,appFactory,utilFactory,$http){
	
	$scope.model={};
	
	$scope.reset=function(){
        $scope.model.memId="";
        $scope.model.bookId="";
        $scope.bookData={};
        $scope.memData={};
    };

	getBookDetails=function(){
		if($scope.model.bookId!='' && $scope.model.bookId!=undefined){
			$scope.book=appFactory.getBookDetails($scope.model.bookId).then(function(data){
				$scope.bookData=data.data;
				$scope.bookDetails=appFactory.getDetails($scope.model.bookId).then(function(data){
					$scope.bookDetails=data.data;
					});
				});
			}
		};
		
	getMemberDetails=function(){
		if($scope.model.memId!='' && $scope.model.memId!=undefined){
			$scope.book=appFactory.getMemberDetails($scope.model.memId).then(function(data){
				$scope.memData=data.data;
				});
			}
		};
		
		$scope.sendPost = function() {
			if(!($scope.memData.noOfBooks >= '3') && !($scope.memData.totalFine >= '500') && ($scope.bookDetails.bId=='0')){
				$scope.formValid=true;
	        $http({
	            url : 'issue',
	            method : "POST",
	            data : {
	                'mod' : $scope.model,
	            }
	        }).then(function(response) {
	        	$scope.reset();
	            alert("Success");
	        }, function(response) {
	            //fail case
	            console.log(response);
	            $scope.message = response;
	        });
			}
			else{
				$scope.formValid=false;
			}
	    };
		
	

	function init(){
		$scope.model.memId="";
		$scope.model.bookId="";
		$scope.model.issueDate=new Date();
	    $scope.model.dueDate=new Date();
	    $scope.model.dueDate.setDate($scope.model.issueDate.getDate()+14); 
	};
	
	init();
});