import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import {Menu,Segment} from 'semantic-ui-react';

class App extends Component {

    state = { activeItem: 'клиент' }

    handleItemClick = (e, { name }) => this.setState({ activeItem: name })

  render() {
      const  activeItem  = this.state.activeItem

    return (
      <div className="App">
        <header className="App-header">
          <Segment inverted>
      <Menu inverted pointing secondary>
  <Menu.Item name='клиент' active={activeItem === 'клиент'} onClick={this.handleItemClick} />
  <Menu.Item name='курьер' active={activeItem === 'курьер'} onClick={this.handleItemClick} />
  <Menu.Item name='склад' active={activeItem === 'склад'} onClick={this.handleItemClick} />
  <Menu.Item name='админ' active={activeItem === 'админ'} onClick={this.handleItemClick} />
      </Menu>
      </Segment>
        </header>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
      </div>
    );
  }
}

export default App;
