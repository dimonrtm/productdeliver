import React, { Component } from 'react';
import {Menu,Segment} from 'semantic-ui-react';

export class MyMenu extends Component
{
    state = { activeItem: 'клиент' }
    
        handleItemClick = (e, { name }) => this.setState({ activeItem: name })
    render()
    {const  activeItem  = this.state.activeItem;
        return(<div className="Menu">
        <Segment inverted>
      <Menu inverted pointing secondary>
  <Menu.Item name='клиент' active={activeItem === 'клиент'} onClick={this.handleItemClick} />
  <Menu.Item name='курьер' active={activeItem === 'курьер'} onClick={this.handleItemClick} />
  <Menu.Item name='склад' active={activeItem === 'склад'} onClick={this.handleItemClick} />
  <Menu.Item name='админ' active={activeItem === 'админ'} onClick={this.handleItemClick} />
      </Menu>
      </Segment>
        </div>);
    }
}