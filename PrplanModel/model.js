'use strict';
var mongoose = mongoose.Schema;
var Schema = mongoose.Schema;



var itemSchema = new Schema ({
	item_title: {
		type: String,
		required: 'Kindly enter the item title'
	},

	start_date: {
		type: Date
	},

	end_date: {
		type: Date
	},

	item_cost: {
		type: Number,
		required: 'Kindly enter cost of item'
	}

});

var ProjectSchema = new Schema({
	name: {
		type: String,
		required: 'Kindly enter the name of the Project'
	},
	start_date: {
		type: Date,
		default: Date.now
	},

	status: {
    type: [{
      	type: String,
      	enum: ['pending', 'ongoing', 'completed']
    }],
    default: ['pending']
	},

	items: [itemSchema],

	end_date: {
		type: Date

	},

	total_cost: {
		type: Number
	}

});


module.exports = mongoose.model('Projects', ProjectSchema);
module.exports = mongoose.model('Items', itemSchema);