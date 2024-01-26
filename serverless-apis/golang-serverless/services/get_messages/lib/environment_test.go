package lib

import (
	"github.com/stretchr/testify/assert"

	"testing"
)

func TestGetEnvironment(t *testing.T) {
	environment := NewEnvironment()
	assert.Equal(t, false, environment.Debug)
	assert.Equal(t, "", environment.Region)
	assert.Equal(t, "", environment.ConversationsTablename)
	assert.Equal(t, "", environment.MessagesTablename)
}
