var aMailServices = angular.module('AMail',['ngRoute']);

function emailRouteConfig($routeProvider){
	$routeProvider.when('/',{controller:'ListController',templateUrl:'amail/list.html'}).
					when('/view/:id',{controller:'DetailController',templateUrl:'amail/detail.html'}).
					otherwise({redirectTo:'/'});
}

aMailServices.config(emailRouteConfig);

messages=[{
	id:0, sender:'jean@cc.com', subject:'Hi man!',date:'Dec 7, 2015 11:00))', recipients:['jim@cc.com'], message:'Hi, long time no see.'
},{
	id:1, sender:'carl@cc.com', subject:'old man!',date:'Dec 7, 2015 11:00))', recipients:['jim@cc.com'], message:'boy, long time no see.'
},{
	id:2, sender:'harry@cc.com', subject:'how!',date:'Dec 7, 2015 11:00))', recipients:['jim@cc.com'], message:'hi man, long time no see.'
},{
	id:3, sender:'hellen@cc.com', subject:'good',date:'Dec 7, 2015 11:00))', recipients:['jim@cc.com'], message:'so, long time no see.'
}];


function ListController($scope){
	$scope.messages = messages;
}

function DetailController($scope, $routeParams){
	$scope.message = messages[$routeParams.id];
}
