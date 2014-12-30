//angular.module("defaultApp", [])
//    .controller("gridController", function($scope) {
//        $scope.helloTo = {};
//        $scope.helloTo.title = "World, AngularJS";
//    } );

var app = angular.module('defaultApp', ['ngAnimate', 'ngTouch', 'ui.grid','ui.bootstrap']);

app.controller('MainCtrl', ['$scope','$http', function ($scope,$http) {

	  $scope.gridOptions1 ={
			  
			  height:"auto",
	  };

	$http.get('/students').success(function(data)
	{
      $scope.gridOptions1.data = data;
    });
}]);

app.controller('ModalDemoCtrl', function ($scope, $modal, $log,$http,$interval) {
	var modalInstance;
  $scope.open = function (size) {
	  $http.get('/student').success(function(data){
		  modalInstance= $modal.open({
      template: 	data,
      controller: 'ModalInstanceCtrl',
      size: size,
    });
 });
 };
});

//Please note that $modalInstance represents a modal window (instance) dependency.
//It is not the same as the $modal service used above.

angular.module('defaultApp').controller('ModalInstanceCtrl', function ($scope, $modalInstance, $http) {

	 $scope.student = {};
     $scope.student.id = 0;
   	 $http.get('/dept').success(function(data) 
	    {
	        $scope.depts = data; 
	        $scope.student.dept=data[0];
	    });
 
	 $http.get('/grade').success(function(data) 
		{
		    $scope.grades = data; 
		    $scope.student.grade=data[0];
		});
			 
	
$scope.cancel = function () {
	  dismiss("cancel");
};

$scope.enrollStudent =  function ()
{

	// Simple POST request example (passing data) :
	var req = {
			 method: 'POST',
			 url: '/students',
			 headers: {
			   'Content-Type': "application/json"
			 },
//			 data: [{"enrollNo":$scope.student.enrollNo,"rollNo":$scope.student.rollNo,"name":$scope.student.name,"grade":$scope.student.grade,"dept":$scope.student.dept}],
			 data: [$scope.student],
			}

			$http(req).success(function(data, status, headers, config) {
				// this callback will be called asynchronously
				// when the response is available
				close("ok");
			}).error(function(data, status, headers, config) {
				// called asynchronously if an error occurs
				// or server returns response with an error status.
			});
};

});
