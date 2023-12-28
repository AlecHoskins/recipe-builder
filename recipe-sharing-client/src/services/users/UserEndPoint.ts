// 
import Endpoint from '../BaseEndPoint';
import UserDTO from './UserDto';

class UserEndPoint extends Endpoint {
    getUserById = (id: number) => this.get<UserDTO>(`/id?=${id}`).then((res) => {
        debugger
        res.data
    });
    // getAppInfo = async () =>
    //     (await this.get<GetCurrentLoginInformationOutput>('')).data.result;
    getUserByToken = () => this.get<UserDTO>().then((res) => {
        debugger
        res.data
    });
}

export const UserServices = new UserEndPoint('/User');
