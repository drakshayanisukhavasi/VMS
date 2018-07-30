<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" ng-app="vms" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" ng-app="vms" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" ng-app="vms" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en" ng-app="vms" class="no-js"> <!--<![endif]-->
<head>
    <meta charset="UTF-8">
    <base href="/${context}/">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=yes">

    <title>VMS - Vehicle Management System</title>

    <!-- CSS -->
     <link rel="stylesheet" type="text/css" href="/${context}/wro/bundledCss.css?v=${version}" />
     <!-- <link rel="stylesheet" type="text/css" href="/vms/webjars/bootstrap/3.3.6/css/bootstrap.min.css?v=${version}" /> -->
    <!-- Dev note, need to add 16x16 and 32x32 versions -->
    <link rel="icon" href="resources/img/logo.png">
     
    <!-- Property injection -->
    <script type="text/javascript">
        var version                         = '${version}';
        var hostname                        = '${hostname}';
        var port                            = '${port}';
        var context                         = '${context}';
        var ssl                             = ${ssl};
    </script>
</head>
<body>
    <div id="wrapper">
        <!-- Navigation -->
		<nav class="navbar navbar-default">
		    <div class="container-fluid">
		        <div class="navbar-header">
		            <a href="/${context}" class="navbar-brand">VMS - Vehicle Management System</a>
		        </div>
		        <div class="collapse navbar-collapse">
		            <ul class="nav navbar-nav">
		                <li><a ui-sref="veh">Home</a></li>
		            </ul>
		            <ul class="nav navbar-nav navbar-right">
		                <li class="dropdown">
		                    <a href="#" class="dropdown-toggle" role="button">Drakshayani Sukhavasi</span></a>
		                </li>
		            </ul>
		        </div>
		    </div>
		</nav>


        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div ui-view></div>
                </div>
            </div>
        </div>


        <!-- Footer -->
        <div class="footer text-center">
               <p>Copy Right @ Drakshayani Sukhavasi</p>
        </div>

    </div>

    <!-- JAVASCRIPT -->
    <script type="text/javascript" src="/${context}/wro/bundledLibJs.js?v=${version}"></script>  
    <script type="text/javascript" src="/${context}/wro/bundledAppJs.js?v=${version}"></script>
    <!-- <script type="text/javascript" src="/${context}/webjars/angularjs/1.5.5/angular.min.js?v=${version}"></script>
    <script type="text/javascript" src="/${context}/resources/js/app.js?v=${version}"></script> -->
</body>
</html>
