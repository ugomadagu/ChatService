var React = require('react');
var TextBoxWithPlaceHolder = require('./Text-Box-With-Placeholder');
var ReactRouter = require('react-router');
var Link = ReactRouter.Link;
var Dropdown = require('./Dropdown');
var ActionButton = require('./Action-Button');
var userServiceURL = "http://localhost:3000"

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
  getInitialState: function() {
    return {sex: "Empty", targetSex: "Empty"}
  },

  updateSexState: function(newSex) {
    this.setState({
      sex: newSex
    });
  },

  updateTargetSexState: function(newTargetSex) {
    this.setState({
        targetSex: newTargetSex
    });
  },

  createUser: function() {
    var request = {
      "firstName": document.getElementById('firstNameField').value,
      "lastName" : document.getElementById('lastNameField').value,
      "email": document.getElementById('emailField').value,
      "zipCode": document.getElementById('zipCodeField').value,
      "age": document.getElementById('ageField').value,
      "hashedPassword": document.getElementById('passwordField').value,
      "sex": this.state.sex,
      "targetSex": this.state.targetSex
    }

    return fetch("http://localhost:3000/api/users", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(request)
    }).then(function(response) {
      console.log("Status is a: " + response.status)
    })
  },

  render: function () {
    return <div>
      <h1>Please Enter your new account details below.</h1>
      <TextBoxWithPlaceHolder id="firstNameField" type="text" textBoxTitle = "First Name" />
      <TextBoxWithPlaceHolder id="lastNameField" type="text" textBoxTitle = "Last Name"/>
      <TextBoxWithPlaceHolder id="emailField" type="text" textBoxTitle = "Email"/>
      <TextBoxWithPlaceHolder id="zipCodeField" type="text" textBoxTitle="Zip Code"/>
      <TextBoxWithPlaceHolder id="ageField" type="text" textBoxTitle="Age"/>
      <TextBoxWithPlaceHolder id="passwordField" type="password" textBoxTitle="Password"/>
      <TextBoxWithPlaceHolder id="confirmPasswordField" type="password" textBoxTitle="Confirm Password"/>
      <Dropdown items={sexes.items} sendUpdate={this.updateSexState} title={sexes.title}></Dropdown>
      <Dropdown items={orientation.items} sendUpdate={this.updateTargetSexState} title={orientation.title}></Dropdown>
      <ActionButton btnColor='btn btn-info' btnText='Create Account' handleClick={this.createUser}></ActionButton>

    </div>
  }
});
