/**
 * @author Venkatesh Kadimisetty
 *
 * @Date Jul 18, 2016
 */
app.controller('addMemberController',function($scope,$http){
	$scope.model={};
	
	
	$scope.reset=function(){
		$scope.model.fname="";
		$scope.model.sid="";
		$scope.model.mobile="";
	    $scope.model.email="";
	    $scope.model.b_limit=3;
	    $scope.model.no_books=0;
	    $scope.model.fine=0;
	    $scope.model.issueDate=new Date();
	};
	
	$scope.addMember=function(){
		
		if($scope.memDetails.sId==0 && $scope.model.sid!='' && $scope.model.sid!=undefined){
	
        $http({
            url : 'addMem',
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
    
    $scope.getMemberDetails=function(){
    	if($scope.model.sid!='' && $scope.model.sid!=undefined){
    	var getDetails=$http.get('memd?memId='+$scope.model.sid).then(function(data){
    		$scope.memDetails=data.data;
    	},function(error){
    		console.log(error);
    	});
    	}
    };
	
	function init(){
		$scope.model.fname="";
		$scope.model.sid="";
		$scope.model.mobile="";
	    $scope.model.email="";
	    $scope.model.b_limit=3;
	    $scope.model.no_books=0;
	    $scope.model.fine=0;
	    $scope.model.issueDate=new Date();
	};
	
	init();
});