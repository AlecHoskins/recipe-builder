// 
import Endpoint from '../BaseEndPoint';
import UserDTO from './UserDto';

class UserEndPoint extends Endpoint {
    getUserById = (id: number) => this.get<UserDTO>(`/id?=${id}`).then((res) => {
        debugger
        res.data
    });

    getUserByToken = () => this.get<object>("");
}

export const UserServices = new UserEndPoint('/User');
