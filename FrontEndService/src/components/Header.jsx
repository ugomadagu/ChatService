var React = require('react')
var ReactRouter = require('react-router');
var Link = ReactRouter.Link;
var Reflux = require("reflux")

module.exports = React.createClass({
  render: function() {
    return <nav className="navbar navbar-default header">
      <div className="container-fluid">
        <Link to="/" className="navbar-brand">
          Tru Talk
        </Link>
      </div>
    </nav>
  },
})
