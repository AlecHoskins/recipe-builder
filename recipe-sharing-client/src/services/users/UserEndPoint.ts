// 
import Endpoint from '../BaseEndPoint';
import UserDTO from './UserDto';

class UserEndPoint extends Endpoint {
    getUserById = (id: number) => this.get<UserDTO>(`/id?=${id}`).then((res) => {
        return res.data;
    });

    getUser = () => this.get<UserDTO>("").then((res)=> {
        return res.data;
    });
}

export const UserServices = new UserEndPoint('/User');
