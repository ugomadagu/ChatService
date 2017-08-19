var React = require('react');
var LoginButton = require('./Login-Button');
var TextBoxWithPlaceHolder = require('./Text-Box-With-Placeholder');
var ReactRouter = require('react-router')
var Link = ReactRouter.Link

module.exports = React.createClass({
  render: function () {
    return <div>
      <TextBoxWithPlaceHolder type="text" placeholder='UserName'></TextBoxWithPlaceHolder>
      <TextBoxWithPlaceHolder type="password" placeholder='Password'></TextBoxWithPlaceHolder>
      <Link to={"signup/"}>
        <LoginButton btnColor='btn btn-default' btnText='Create Account'></LoginButton>
      </Link>
      <LoginButton btnColor='btn btn-info' btnText='Login'></LoginButton>
    </div>
  }
});
