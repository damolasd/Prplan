var Projects = require('./PrplanModel/model.js')
var express = require('express');
var app = express();
mongoose = require('mongoose');
var dbName = 'Prplan';
var connectionString = 'mongodb://localhost:27017/' + dbName

mongoose.connect(connectionString);
port  =process.env.PORT || 3000;
app.listen(port);


app.get('/Projects', function(req, res) { 
	Projects.find(function(err,project) {
		if (err) {
			return res.send(err);
		}
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
console.log('todo list RESTful API server started on: '+ port);
