import Endpoint from '../BaseEndPoint';
import { GetCurrentLoginInformationOutput } from './dtos/GetCurrentLoginInformationsOutput';

class AppEndPoint extends Endpoint {
  getAppInfo = async () =>
    (await this.get<GetCurrentLoginInformationOutput>('')).data.result;
}

export const App = new AppEndPoint('Application');
