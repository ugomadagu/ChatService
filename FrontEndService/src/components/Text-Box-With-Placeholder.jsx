var React = require('react');

module.exports = React.createClass({
  render: function() {

    return <div className="input-group" style={{marginTop: '5px'}}>
      <span className="input-group-addon" id="basic-addon1">{this.props.textBoxTitle}</span>
      <input type={this.props.type} className="form-control" placeholder={this.props.placeholder} aria-describedby="basic-addon1"/>
    </div>
  }
});
