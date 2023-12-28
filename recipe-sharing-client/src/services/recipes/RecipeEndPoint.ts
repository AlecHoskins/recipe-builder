import Endpoint from "../BaseEndPoint";
import RecipeDTO from "./dto/RecipeDto";

// export const App = new AppEndPoint('Application');

class RecipeEndPoint extends Endpoint {
    getById = (id: number) => this.get<RecipeDTO>(`GetById/${id}`).then((res) => res.data );
    getByName = (name: string) => this.get<RecipeDTO>(`GetByName/${name}`).then((res) => res.data);
    getAll = () => this.get<Array<RecipeDTO>>(`/All`).then((res) => res.data);
    save = (data: RecipeDTO) => this.post<RecipeDTO>(`/Save`, data).then((res) => res.data);
    deleteById = (id: number) => this.delete<object>(`/Delete/${id}`).then((res) => res.data);
}
export const RecipeServices = new RecipeEndPoint("/Recipe");