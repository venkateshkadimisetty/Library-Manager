/**
 * Created by Venkatesh Kadimisetty
 * Date: 7/5/2016.
 */

app.controller('returnBookController',function($scope,appFactory,utilFactory,$http){
	
	$scope.model={};
	
	$scope.reset=function(){
        $scope.model.memId="";
        $scope.model.bookId="";
        $scope.model.issueDate="";
        $scope.model.dueDate="";
        $scope.model.fine="";
        $scope.bookData={};
        $scope.memData={};
    };
    
    $scope.submit=function(){
    	if(($scope.model.memId!='0') && ($scope.model.bookId!='0'))
    		{
    	$http({
            url : 'retb',
            method : "DELETE",
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
    }
    
    getDetails=function(){
    	if($scope.model.bookId!='' && $scope.model.bookId!=undefined){
    		$scope.bookData={};
            $scope.memData={};
			$scope.bookDetails=appFactory.getDetails($scope.model.bookId).then(function(data){
				console.log(data);
				$scope.bookLendData=data.data;
				$scope.model.memId=$scope.bookLendData.sId;
				$scope.model.issueDate=utilFactory.getParsedDate($scope.bookLendData.issueDate);
				$scope.model.dueDate=utilFactory.getParsedDate($scope.bookLendData.dueDate);
				if($scope.model.submissionDate > $scope.model.dueDate){
				$scope.model.fine=utilFactory.getDifferenceDays($scope.model.submissionDate,$scope.model.dueDate);
				}
				else
					$scope.model.fine=0;
					
				if($scope.model.memId!=0)
					{
				$scope.book=appFactory.getBookDetails($scope.model.bookId).then(function(data){
					$scope.bookData=data.data;
					$scope.member=appFactory.getMemberDetails($scope.bookLendData.sId).then(function(data){
						$scope.memData=data.data;
					});
				});
				}
			});
		}
    };

	function init(){
		$scope.model.memId="";
		$scope.model.bookId="";
		$scope.model.fine="";
		$scope.model.submissionDate=new Date();
	};
	
	init();
});