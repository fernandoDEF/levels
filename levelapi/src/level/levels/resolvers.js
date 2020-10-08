import { generalRequest, getRequest } from '../../utilities';
import { url, port, entryPoint } from './server';

const URL = `http://${url}:${port}/${entryPoint}`;

const resolvers = {
	Query: {
		allLevels: (_) =>
			getRequest(URL, ''),
		levelById: (_, { id }) =>
			generalRequest(`${URL}/${id}`, 'GET'),
	},
	Mutation: {
		createLevel: (_, { level }) =>
			generalRequest(`${URL}/`, 'POST', level),
		updateLevel: (_, { id, level }) =>
			generalRequest(`${URL}/${id}`, 'PUT', level),
		deleteLevel: (_, { id }) =>
			generalRequest(`${URL}/${id}`, 'DELETE')
	}
};

export default resolvers;
