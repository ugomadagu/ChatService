var React = require('react');

module.exports = React.createClass({
  render: function() {
    return <span><a className={this.props.btnColor} role="button" onClick={this.props.handleClick} style={{marginTop: '10px', marginRight: '5px'}} >{this.props.btnText}</a>
    </span>
  }
});
