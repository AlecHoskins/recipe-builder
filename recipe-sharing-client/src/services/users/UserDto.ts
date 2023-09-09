import IngredientDTO from "../ingredients/IngredientDto";
import InstructionDTO from "../instructions/InstructionDto";

export default interface UserDTO {
    id: number;
    username: string;
    email: string;
    roles: Array<string> //todo later if using permissions, add permissions to roles and make a role dto
}