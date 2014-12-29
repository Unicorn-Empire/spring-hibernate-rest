<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!doctype html>
<html ng-app= "defaultApp">
  <head>
    <title>School Rest</title>
	<link   href="/resources/js/jqComponentsAll/jqc-all.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
    <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="resources/js/jqComponentsAll/jqc-all.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular-touch.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular-animate.js"></script>
	<script src="/resources/js/bootstrap/ui-bootstrap-tpls-0.12.0.min.js"></script>
<!-- 	<script src="http://ui-grid.info/docs/grunt-scripts/csv.js"></script> -->
<!--     <script src="http://ui-grid.info/docs/grunt-scripts/pdfmake.js"></script> -->
<!--     <script src="http://ui-grid.info/docs/grunt-scripts/vfs_fonts.js"></script> -->
    <link rel="stylesheet" href="http://ui-grid.info/release/ui-grid-unstable.css" type="text/css">
    <script src="http://ui-grid.info/release/ui-grid-unstable.js"></script>
    <script src="/resources/app/homeController.js"></script>
</head>

<body>

<P>  The time on the server is ${serverTime}. </P>


<div ng-controller="MainCtrl">
<h4>Students</h4>
  <div id="grid" ui-grid="gridOptions1" class="grid"></div>
</div>
<div ng-controller="ModalDemoCtrl">
 

<!--     <button class="btn btn-default" ng-click="open()">Open me!</button> -->
<!--     <button class="btn btn-default" ng-click="open('lg')">Large modal</button> -->
    <button class="btn btn-default" ng-click="open('sm')">Add Student</button>
</div>
</body>
</html>
