var React = require('react');

module.exports = React.createClass({
  render: function() {
    return <span><a className={this.props.btnColor} role="button" onClick={this.logIn} style={{marginTop: '10px', marginRight: '5px'}} >{this.props.btnText}</a>
    </span>

  },

  logIn: function() {
    var btnText = this.props.btnText
    if(btnText == 'Login') {
      window.location.href='homePage.html'
    }
  }
});
