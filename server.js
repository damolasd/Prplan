var Projects = require('./PrplanModel/model.js') // Data Model 
var routes = require('./PrplanRoutes/routes.js')
bodyParser =  require('body-parser');
var express = require('express');
var app = express();
// Database
mongoose = require('mongoose');
var dbName = 'Prplan';
var connectionString = 'mongodb://localhost:27017/' + dbName
mongoose.Promise = global.Promise
mongoose.connect(connectionString);

app.use(bodyParser.urlencoded({extended:true}));
app.use(bodyParser.json());



routes(app);

app.use(function(req, res) {
  res.status(404).send({url: req.originalUrl + ' not found'})
});


port  =process.env.PORT || 3000;
app.listen(port);

/*
app.get('/Projects', function(req, res) { 
	Projects.find({},function(err,project) {


		if (err) {
			return res.send(err);
		}

		var projectMap = {};
		project.forEach(function(user) {
			projectMap[project._id] = project;
		});
		res.send(userMap);
		res.json(project)
	});

});

app.get('/Projects/ProjectId/Items', function(req, res) {

})


app.post('/Projects', function(req, res){
	var project = new Projects(req.body);

	project.save(function(err) {
		if (err) {
			return res.send(err);
		}
		res.send({message: 'Project added'});
	});

});

app.put('/Projects', function (req, res) {
	// body...
})

app.delete('/Projects', function(req, res) {

})

*/
console.log('todo list RESTful API server started on: '+ port);
