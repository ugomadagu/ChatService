var React = require('react');
var TextBoxWithPlaceHolder = require('./Text-Box-With-Placeholder');
var ReactRouter = require('react-router');
var Link = ReactRouter.Link;
var Dropdown = require('./Dropdown');

var sexes = {
  title: 'I am a :',
  items: [
    'Man',
    'Woman'
  ]
};

var orientation = {
  title: 'Looking for a : ',
  items: [
    'Man',
    'Woman'
  ]
};

module.exports = React.createClass({
  render: function () {
    return <div>
      <h1>Please Enter your new account details below.</h1>
      <TextBoxWithPlaceHolder type="text" textBoxTitle = "First Name" />
      <TextBoxWithPlaceHolder type="text" textBoxTitle = "Last Name"/>
      <TextBoxWithPlaceHolder type="text" textBoxTitle="Zip Code"/>
      <TextBoxWithPlaceHolder type="text" textBoxTitle="Age"/>
      <TextBoxWithPlaceHolder type="password" textBoxTitle="Password"/>
      <TextBoxWithPlaceHolder type="password" textBoxTitle="Confirm Password"/>
      <Dropdown items={sexes.items} title={sexes.title}></Dropdown>
      <Dropdown items={orientation.items} title={orientation.title}></Dropdown>

    </div>
  }
});
