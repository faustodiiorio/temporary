angular.module('home', ['ui.router'])
	.config(['$urlRouterProvider', '$locationProvider', function($urlRouterProvider, $locationProvider){
		$locationProvider.html5Mode(true);
//		la seguente per il cambio di state
//		$stateProvider
//			.state({
//				name: 'home',
//				url: 'temporary/'
//			})
	}])
	.controller('HomeController', ['$http', function ($http){
		var home = this;
//		nel caso di un parametro che proviene da una request get
//		home.searchParam = $stateProvider.nome;
//		risultato "statico", hardcoded
		home.searchParam = "fausto";
		home.validate = function() {
			home.person = [];
			var getPerson = $http.get('http://localhost:8080/temporary/home/getPersonByName?nome=' + home.searchParam)
			getPerson.then(function(result) {
			    home.person = result.data;
			});
		};
		home.validate();
		
		home.header = "temporary/views/header.html";
		home.footer = "temporary/views/footer.html";
	}]);