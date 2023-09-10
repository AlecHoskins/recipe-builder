// 
import Endpoint from '../BaseEndPoint';
import UserDTO from './UserDto';

class AppEndPoint extends Endpoint {
    getUserById = (id: number) => this.get<UserDTO>(`/User/id?=${id}`).then((res) => res.data);
    // getAppInfo = async () =>
    //     (await this.get<GetCurrentLoginInformationOutput>('')).data.result;
}

export const App = new AppEndPoint('Application');
