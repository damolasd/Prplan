'use strict';
module.exports = function(app) {
	var controller = require('../PrplanController/controller');

app.route('/Projects')
	.get(controller.list_projects)
	.post(controller.create_project);


app.route('/Projects/ProjectId')
	.get(controller.list_items)
	.post(controller.update_project)
	.post(controller.create_item)
	.delete(controller.delete_project);


app.route('/Projects/ProjectId/ItemId')
	.post(controller.update item)
	.delete(controller.delete_item)





};
