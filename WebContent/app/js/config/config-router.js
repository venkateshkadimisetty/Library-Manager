/**
 * Created by Venkatesh Kadimisetty
 * Date: 07/04/2016.
 */
app.config(function($stateProvider, $urlRouterProvider){

    // For any unmatched url, send to /issueBook
  /*  $urlRouterProvider.otherwise("/")*/

    $stateProvider
        .state('addBooks', {
            url: "addBooks",
            templateUrl: "app/view/addBooks.html",
            controller:"addBookController"
        })
        .state('addMembers', {
            url: "addMembers",
            templateUrl: "app/view/addMembers.html",
            controller:"addMemberController"
        })
        .state('issueBook', {
            url: "issueBook",
            templateUrl: "app/view/issueBook.html",
            controller:"issueBookController"
            /*resolve:{
            	data:function(appFactory){
            		return appFactory.issueBook();
            	}
            }*/
        })
        .state('returnBook', {
            url: "returnBook",
            templateUrl: "app/view/returnBook.html",
            controller:"returnBookController"
        })
        .state('home', {
            url: "home",
            templateUrl: "app/view/home.html"
        })
        .state('home1', {
            url: "/",
            templateUrl: "app/view/home.html"
        });
    /*$urlRouterProvider.otherwise("/");*/
});