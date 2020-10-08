export const levelTypeDef = `
  type Category {
      id: Int!
      name: String!
      level: String!
      progress: Float!
      enable: Boolean!
  }
  input CategoryInput {
      name: String!
      level: String!
      progress: Float!
      enable: Boolean!
  }`;

export const levelQueries = `
      allLevel: [Level]!
      levelById(id: Int!): Level!
  `;

export const levelMutations = `
    createLevel(level: levelInput!): level!
    updateLevel(id: Int!, level: levelInput!): level!
    deleteLevel(id: Int!): Int
`;
