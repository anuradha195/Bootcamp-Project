//$(document).ready(function(){
//$getJSON('http://localhost:8080/api/charts/default'function(json_data){
// // Get the context of the canvas element we want to select
//    var ctx=document.getElementById("weeklyStepChart").getContext("2d");
//
//  // Instantiate a new chart using 'data'
//    var chart new Chart(ctx,data);
//    });
//
//    $ajax({
//    type:'POST',
//    url: 'http://localhost:8080/api/auth/oauth',
//    data: '{"url"   :"'+document.URL+'"}',
//    success:function(data) {console.log('data: '+data);},
//    contentType:"application/json",
//    dataType: 'json'
//    });
//
//});
function renderChart(data, labels) {
	var ctx = document.getElementById("myChart").getContext('2d');
	var myChart = new Chart(ctx, {
		type: 'line',
		data: {
			labels: labels,
			datasets: [{
				label: 'Weekly Step Chart',
				data: data,
			}]
		},
	});
}
//$("#renderBtn").click(
window.onload = function () {
	data = /*[[${steps}]]*/ [100, 900];
	//[20000, 14000, 12000, 15000, 18000, 19000, 22000];
	labels = /*[[${labels}]]*/ ['', ''];
	//["sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"];
	renderChart(data, labels);
};