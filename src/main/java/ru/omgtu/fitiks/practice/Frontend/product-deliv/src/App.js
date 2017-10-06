import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import {Menu,Segment} from 'semantic-ui-react';

class App extends Component {

    state = { activeItem: 'продукты' }

    handleItemClick = (e, { name }) => this.setState({ activeItem: name })

  render() {
      const  activeItem  = this.state.activeItem

    return (
      <div className="App">
        <header className="App-header">
          <Segment inverted>
      <Menu inverted pointing secondary>
      <Menu.Item name='продукты' active={activeItem === 'продукты'} onClick={this.handleItemClick} />
  <Menu.Item name='клиенты' active={activeItem === 'клиенты'} onClick={this.handleItemClick} />
  <Menu.Item name='курьеры' active={activeItem === 'курьеры'} onClick={this.handleItemClick} />
  <Menu.Item name='склады' active={activeItem === 'склады'} onClick={this.handleItemClick} />
  <Menu.Item name='машины-доставки' active={activeItem === 'машины-доставки'} onClick={this.handleItemClick} />
  <Menu.Item name='пакеты-товаров' active={activeItem === 'пакеты-товаров'} onClick={this.handleItemClick} />
      <Menu.Item name='доставки-клиентам' active={activeItem === 'доставки-клиентам'} onClick={this.handleItemClick} />
  <Menu.Item name='доставки-на-склады' active={activeItem === 'доставки-на-склады'} onClick={this.handleItemClick} />
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
