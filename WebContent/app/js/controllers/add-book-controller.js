/**
 * @author Venkatesh Kadimisetty
 *
 * @Date Jul 20, 2016
 */

app.controller('addBookController',function($scope,$http){
	
	$scope.model={};
	
	
	$scope.reset=function(){
		$scope.model.bname="";
		$scope.model.bid="";
		$scope.model.bauthor="";
		$scope.model.bdate=new Date();
	};
	
	   $scope.getBookDetails=function(){
	    	if($scope.model.bid!='' && $scope.model.bid!= undefined){
	    	var getDetails=$http.get('demo?bookId='+$scope.model.bid).then(function(data){
	    		$scope.bookDetails=data.data;
	    	},function(error){
	    		console.log(error);
	    	});
	    	}
	    };
	
	$scope.addBook=function(){
		if($scope.bookDetails.bId==0 && $scope.model.bid!=''){
        $http({
            url : 'addBook',
            method : "POST",
            data : {
                'mod' : $scope.model,
            }
        }).then(function(response) {
            alert("Success");
            $scope.reset();
        }, function(response) {
            //fail case
            console.log(response);
            $scope.message = response;
        });
		}
 
    };
	
	function init(){
		$scope.model.bname="";
		$scope.model.bid="";
		$scope.model.bauthor="";
		$scope.model.bdate=new Date();
	}
	
	init();
});