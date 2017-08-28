var React = require('react');
var ActionButton = require('./Action-Button');
var TextBoxWithPlaceHolder = require('./Text-Box-With-Placeholder');
var ReactRouter = require('react-router')
var Link = ReactRouter.Link

module.exports = React.createClass({

  logIn: function() {
    window.location.href='homePage.html'
  },

  render: function () {
    return <div>
      <TextBoxWithPlaceHolder type="text" placeholder='UserName'></TextBoxWithPlaceHolder>
      <TextBoxWithPlaceHolder type="password" placeholder='Password'></TextBoxWithPlaceHolder>
      <Link to={"signup/"}>
        <ActionButton btnColor='btn btn-default' btnText='Sign Up'></ActionButton>
      </Link>
      <ActionButton btnColor='btn btn-info' handleClick={this.logIn} btnText='Login'></ActionButton>
    </div>
  }
});
